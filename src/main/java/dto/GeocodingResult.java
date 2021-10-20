package dto;

import java.util.List;

public class GeocodingResult {
	private List<GeocodingAddress> address_components;

	public List<GeocodingAddress> getAddress_components() {
		return address_components;
	}

	public void setAddress_components(List<GeocodingAddress> address_components) {
		this.address_components = address_components;
	}

	@Override
	public String toString() {
		return "GeocodingResult [address_components=" + address_components + "]";
	}
	
}
