package com.covid.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid.model.CovidData;
import com.covid.repository.CovidRepository;
import com.covid.service.CovidDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.CovidDataDTO;
import dto.GeocodingAddress;
import dto.GeocodingResult;
import dto.RequestDTO;
import dto.ReverseGeocodingDataDTO;
import dto.StateWiseData;

@Service
public class CovidDataServiceImplementation implements CovidDataService{

	@Value("${covid.api.url}")
    private String covidApiUrl;
	
	@Value("${covid.api.app.key}")
	private String key;
	
	@Value("${google.map.geocoding.url}")
    private String covidGeocodingUrl;
	
	private static final Logger logger = LoggerFactory.getLogger(CovidDataServiceImplementation.class.getName());
	
	@Autowired
	private CovidRepository objCoivdRepository;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public void saveCovidData() throws Exception
	{
		
		ResponseEntity<String> response = restTemplate.getForEntity(covidApiUrl , String.class);
		CovidDataDTO covidDataDTO = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(response.getBody(), CovidDataDTO.class);
        CovidData covidData = new CovidData();
        List<StateWiseData> list = covidDataDTO.getStatewise();
        List<CovidData> covidDataList = new ArrayList<>();
        for(StateWiseData stateWiseData : list) {
        	CovidData stateWise = new CovidData();
        	stateWise.setActive(stateWiseData.getActive());
        	stateWise.setConfirmed(stateWiseData.getConfirmed());
        	stateWise.setDeaths(stateWiseData.getDeaths());
        	stateWise.setRecovered(stateWiseData.getRecovered());
        	stateWise.setState(stateWiseData.getState());
        	stateWise.setStatecode(stateWiseData.getStatecode());
        	stateWise.setLastupdatedtime(stateWiseData.getLastupdatedtime());
        	
        	covidDataList.add(stateWise);
        }
        
        objCoivdRepository.saveAll(covidDataList);
	}
	
	
	
	@Override
	public CovidData getReverseGeocoding(RequestDTO objRequestDTO) throws Exception
	{
		String url = new StringBuilder(covidGeocodingUrl).append(objRequestDTO.getLat()).append(",").append(objRequestDTO.getLng()).append("&key=").append(key).toString();
		logger.info("{}", url);
		
		ResponseEntity<String> response = restTemplate.getForEntity(url , String.class);
		ReverseGeocodingDataDTO reverseGeocodingDataDTO = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(response.getBody(), ReverseGeocodingDataDTO.class);
		List<GeocodingResult> geocodingResultList = reverseGeocodingDataDTO.getResults();
		logger.info("{}", geocodingResultList);
		
		String stateCode = "";
		
		try
		{
			GeocodingResult geocodingResult = geocodingResultList.get(0);
			List<GeocodingAddress> list = geocodingResult.getAddress_components();
			
			for(GeocodingAddress geocodingAddress : list)
			{
				if(geocodingAddress.getTypes().get(0).equals("administrative_area_level_1"))
				{
					logger.info("{}", geocodingAddress.getShort_name());
					stateCode = geocodingAddress.getShort_name();
					break;
				}
			}
			
			return objCoivdRepository.findById(stateCode).orElse(null);
		}
		catch(Exception e){
			return null;
		}	
		
	}
	
	@Override
	public List<CovidData> fetchAllData()
	{
		try
		{
			return objCoivdRepository.findAll();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@Override
	public CovidData fetchDataForState(String stateCode)
	{
		try
		{
			return objCoivdRepository.findByStatecode(stateCode);
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
