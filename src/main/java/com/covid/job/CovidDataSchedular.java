package com.covid.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.covid.service.CovidDataService;

@Service
public class CovidDataSchedular {

	@Autowired
	private CovidDataService objCovidDataService;
	
	@Scheduled(cron = "* */5  * * * *", zone = "Asia/Kolkata") // every 2 minute
	public void fetchData() throws Exception
	{
		objCovidDataService.saveCovidData();
	}
}
