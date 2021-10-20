package dto;

public class StateWiseData {
	
		private String state;
	    private String statecode;
	    private String active;
	    private String confirmed;
	    private String recovered;
	    private String deaths;
	    private String lastupdatedtime;

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

	    public String getRecovered() {
	        return recovered;
	    }

	    public void setRecovered(String recovered) {
	        this.recovered = recovered;
	    }

	    public String getState() {
	    	if(state.equals("Total"))
	    	{
	    		state = "India";
	    	}
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public String getStatecode() {
	    	if(statecode.equals("TT"))
	    	{
	    		statecode = "IND";
	    	}
	        return statecode;
	    }

	    public void setStatecode(String statecode) {
	        this.statecode = statecode;
	    }

	    @Override
	    public String toString() {
	        return "StateWiseData{" +
	                "active='" + active + '\'' +
	                ", confirmed='" + confirmed + '\'' +
	                ", deaths='" + deaths + '\'' +
	                ", lastupdatedtime='" + lastupdatedtime + '\'' +
	                ", recovered='" + recovered + '\'' +
	                ", state='" + state + '\'' +
	                ", statecode='" + statecode + '\'' +
	                '}';
	    }

}
