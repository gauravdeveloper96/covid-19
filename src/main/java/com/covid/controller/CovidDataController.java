package com.covid.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.model.CovidData;
import com.covid.repository.CovidRepository;
import com.covid.service.CovidDataService;

import dto.RequestDTO;


@RestController
@RequestMapping("/")
public class CovidDataController {
	
	@Autowired
	private CovidDataService objCovidDataService;
	
	@GetMapping("/covidIndia")
	public List<CovidData> getCovidDataForIndia() throws Exception
	{
		
		return objCovidDataService.fetchAllData();
	}
	
	@GetMapping("/stateWise/{stateCode}")
	public CovidData getCoviDataForState(@PathVariable String stateCode) throws Exception
	{
		return objCovidDataService.fetchDataForState(stateCode);
	}
	
	@PostMapping("/fetchCovidData/userLocation")
	public CovidData fetchUserStateCovidData(@RequestBody RequestDTO objRequestDTO) throws Exception
	{
		
		return objCovidDataService.getReverseGeocoding(objRequestDTO);
	}
	
	@GetMapping("/fetchCovidData")
	public String get() throws Exception {
		
		objCovidDataService.saveCovidData();
		
		return "Successfully COVID-19 data fetched.";
		
	}
	
}
