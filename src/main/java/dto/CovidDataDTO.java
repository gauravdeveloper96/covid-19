package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CovidDataDTO {
	@JsonProperty("statewise")
	private List<StateWiseData> statewise;

	public List<StateWiseData> getStatewise() {
		return statewise;
	}

	public void setStatewise(List<StateWiseData> statewise) {
		this.statewise = statewise;
	}

}
