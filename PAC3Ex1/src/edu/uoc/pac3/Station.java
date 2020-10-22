package edu.uoc.pac3;

/**
 * Class Station
 * 
 * @author NDevesa
 * @version 1
 */


public class Station {
	/**
	 * The id of the Station
	 */
	private int id;
	/**
	 * next Id
	 */
	private static int nextId = 0;
	/**
	 * name of the Station
	 */
	private String name = "Default";
	/**
	 * Capacity of the Station
	 */
	private int capacity = 24;
	/**
	 * The address of the Station.
	 */
	private Address address;
	
	/**
	 * Constructor Without Parameters 
	 * 
	 * @throws exceptions
	 */
	
	
	public Station() throws Exception {
		this("Default", "Sesame Street", 0.0, 0.0, 24);
	}
	
	/**
	 * Constructor with parameters
	 * 
	 * @param name      
	 * @param street    
	 * @param latitude  
	 * @param longitude 
	 * @param capacity  
	 * @throws Exception 
	 */

	
	public Station(String name, String street, double latitude, double longitude, int capacity) throws Exception {

		setName(name);
		setAddress(street,latitude,longitude);
		setCapacity(capacity);
		setId();
		
	}

	/**
	 * Id Getter
	 * 
	 * @return id
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Id Setter
	 * 
	 */
	
	private void setId() {
		id = nextId;
		plusId();
	}

	/**
	 * Next Id Getter
	 * 
	 * @return nextId
	 */
	
	public static int getNextId() {
		return nextId;
	}
	
	/**
	 * Next Id 
	 */

	
	private void plusId() {
		nextId++;
	}
	
	/**
	 * Name Getter
	 * 
	 * @return name of Station
	 */

	
	public String getName() {
		return name;
	}
	
	/**
	 * Name Setter
	 * 
	 * @param name 
	 * @throws Exception 
	 */

	
	public void setName(String name) throws Exception {
		if (name.length() > 50) {
			throw new Exception("[ERROR] Station's name cannot be longer than 50 characters");
		} else {
			this.name = name;
		}
	}


	/**
	 * Capacity Getter
	 * 
	 * @return nextId
	 */
	
	public int getCapacity() {
		return capacity;
	}
	

	/**
	 * Capacity Setter
	 * 
	 * 
	 */


	public void setCapacity(int capacity) throws Exception {
		if (capacity <= 0) {
			throw new Exception("[ERROR] Station's capacity must be greater than 0");
		} else {
			this.capacity = capacity;
		}
	}

	/**
	 * Address Getter
	 * 
	 * @return Address
	 */

	public Address getAddress() {
		return this.address;
	}
	
	/**
	 * Address Setter
	 * @param Street	
	 * @param Latitude
	 * @param Longitude	
	 */

	public void setAddress(String street, double latitude, double longitude) throws Exception {
		this.address = new Address(street, latitude, longitude);
	}

	
}
	
	
