package com.covid.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.CovidData;

public interface CovidRepository extends MongoRepository<CovidData, String> {

	CovidData findByStatecode(String statecode);
	
}
