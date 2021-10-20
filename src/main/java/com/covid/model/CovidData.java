package com.covid.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CovidData")
public class CovidData {
	
		@Id
	    private String statecode;
	    private String state;	    
	 	private String active;
	    private String confirmed;
	    private String recovered;
	    private String deaths;
	    private String lastupdatedtime;


	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public String getStatecode() {
	        return statecode;
	    }

	    public void setStatecode(String statecode) {
	        this.statecode = statecode;
	    }
	    
	    public String getActive() {
	        return active;
	    }

	    public void setActive(String active) {
	        this.active = active;
	    }

	    public String getConfirmed() {
	        return confirmed;
	    }

	    public void setConfirmed(String confirmed) {
	        this.confirmed = confirmed;
	    }


	    public String getRecovered() {
	        return recovered;
	    }

	    public void setRecovered(String recovered) {
	        this.recovered = recovered;
	    }
	    
	    public String getDeaths() {
	        return deaths;
	    }

	    public void setDeaths(String deaths) {
	        this.deaths = deaths;
	    }

	    public String getLastupdatedtime() {
	        return lastupdatedtime;
	    }

	    public void setLastupdatedtime(String lastupdatedtime) {
	        this.lastupdatedtime = lastupdatedtime;
	    }


	
	
}
