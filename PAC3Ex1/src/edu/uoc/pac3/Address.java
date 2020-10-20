package edu.uoc.pac3;

public class Address {
	
	private static String street = "Sesame Street";

	private static double latitude = 0;
	
	private static double longitude = 0;


	
	public Address(String street, double latitude, double longitude) throws Exception {
		
		setStreet(street);
		setLatitude(latitude);
		setLongitude(longitude);
			
	}
	
	public String getStreet() {
		return street;
	}
	
	public static void setStreet(String street) {
		Address.street = street;
	}
	

	public double getLatitude() {
		return latitude;
	}

	public static void setLatitude(double latitude) throws Exception {
		if (latitude < -90 || latitude > 90) {
			throw new Exception("[ERROR] Address latitude must be in range [-90,+90]");
		} else {
			Address.latitude = latitude;
		}
	}


	public double getLongitude() {
		return longitude;
	}

	public static void setLongitude(double longitude)  throws Exception {
		if (longitude < -180 || longitude > 180) {
			throw new Exception("[ERROR] Address longitude must be in range [-180,+180]");
		} else {
			Address.longitude = longitude;
		}

	}

}