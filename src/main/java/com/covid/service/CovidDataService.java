package com.covid.service;

import java.util.List;
import java.util.Optional;

import com.covid.model.CovidData;

import dto.RequestDTO;

public interface CovidDataService {
	
	public void saveCovidData() throws Exception;
	public CovidData getReverseGeocoding(RequestDTO objRequestDTO) throws Exception;
	public List<CovidData> fetchAllData() throws Exception;
	public CovidData fetchDataForState(String stateCode) throws Exception;
}
