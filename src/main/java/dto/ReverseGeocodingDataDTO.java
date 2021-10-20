package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReverseGeocodingDataDTO {
	
	@JsonProperty("results")
	private List<GeocodingResult> results;

	public List<GeocodingResult> getResults() {
		return results;
	}

	public void setResults(List<GeocodingResult> results) {
		this.results = results;
	}
	

}
