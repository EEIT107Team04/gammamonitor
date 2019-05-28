package ch01; 



public class MemberBean {
	
	private String place;   			
	private String station;   			
	private String measurements;
	private String live;
	private String longitude;    			
	private String	latitude;     	
		// 體重
	
	public MemberBean() {
	} 
	
	public MemberBean(String place, String station, String measurements, String live, String longitude, String latitude
		) {
		super();
		this.place = place;
		this.station = station;
		this.measurements = measurements;
		this.live = live;
		this.longitude = longitude;
		this.latitude = latitude;
		
	}

	
	
	public String toString() {
		return "["+place+","+station+","+measurements+","+live+","+longitude+","+latitude+"]";
	}	

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStation() {
		return station;
	}
	
	public void setStation(String station) {
		this.station = station;
	}

	public String getMeasurements() {
		return station;
	}
	public void setMeasurements(String measurements) {
		this.measurements = measurements;
	}

	public String getLive() {
		return live;
	}

	public void setLive(String live) {
		this.live = live;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


}
