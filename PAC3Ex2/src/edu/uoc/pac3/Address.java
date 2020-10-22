package edu.uoc.pac3;

/**
 * Address Class
 * 
 * @author NDevesa
 * @version 1
 */

public class Address {
	/**
	 * Street Name
	 * 
	 */
	public String street = "Sesame Street";
	/**
	 * Latitude
	 * 
	 */

	public double latitude = 0;
	/**
	 * Longitude
	 * 
	 */
	
	public double longitude = 0;

	/** Address Constructor
	 * @param Street 	
	 * @param Latitude	
	 * @param Longitude	
	 * 
	 * @throws Exceptions
	 */
	
	public Address(String street, double latitude, double longitude) throws Exception {
		
		setStreet(street);
		setLatitude(latitude);
		setLongitude(longitude);
			
	}
	
	/**
	 * Street Getter
	 * 
	 * @return Street
	 * 
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Street Setter
	 * 
	 * 
	 */
	
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * Latitude Getter
	 * 
	 * @return Latitude
	 */

	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Latitude Setter
	 * 
	 * @throws Exceptions, Address' latitude must be in range [-90,+90]
	 */

	public void setLatitude(double latitude) throws Exception {
		if (latitude < -90 || latitude > 90) {
			throw new Exception("[ERROR] Address' latitude must be in range [-90,+90]");
		} else {
			this.latitude = latitude;
		}
	}
	
	/**
	 * Longitude Getter
	 * 
	 * @return Longitude
	 */


	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Longitude Setter
	 * 
	 * @throws Exceptions, Address' longitude must be in range [-180,+180]
	 */

	public void setLongitude(double longitude)  throws Exception {
		if (longitude < -180 || longitude > 180) {
			throw new Exception("[ERROR] Address' longitude must be in range [-180,+180]");
		} else {
			this.longitude = longitude;
		}

	}

}