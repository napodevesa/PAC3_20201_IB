package edu.uoc.pac3;

/**
 * Station Class
 * 
 * @author NDevesa
 * @version 1
 * 
 * 
 */


public class Station {
	/**
	 * Station Id
	 * 
	 * 
	 */
	private int id;
	/**
	 * Next Id
	 * 
	 * 
	 */
	private static int nextId = 0;
	/**
	 * name of the Station
	 * 
	 */
	private String name = "Default";
	/**
	 * Station Capacity
	 * 
	 */
	private int capacity = 24;
	/**
	 *  Station Address
	 *  
	 */
	private Address address;
	
	private Bike[] bikes = new Bike[capacity] ;
	

    
	/**
	 * Constructor Without Parameters 
	 * 
	 * 
	 * 
	 * @throws exceptions
	 */
	
	public Station() throws Exception {
		this("Default", "Sesame Street", 0.0, 0.0, 24);
	}
	
	/**
	 * Constructor with parameters
	 * 
	 * @param Name      
	 * @param Street    
	 * @param Latitude  
	 * @param Longitude 
	 * @param Capacity  
	 * @throws Exception 
	 * 
	 * 
	 */

	
	public Station(String name, String street, double latitude, double longitude, int capacity ) throws Exception {

		setName(name);
		setAddress(street,latitude,longitude);
		setCapacity(capacity);
		setId();		
		
	}

	/**
	 * Id Getter
	 * 
	 * 
	 * @return Id
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Id Setter
	 * 
	 * 
	 * 
	 */
	
	private void setId() {
		id = nextId;
		plus();
	}

	/**
	 * Next Id Getter
	 * 
	 * 
	 * 
	 * @return Next Id
	 */
	
	public static int getNextId() {
		return nextId;
	}
	
	/**
	 * 
	 * plus = Next Id ++
	 * 
	 * 
	 */

	
	private void plus() {
		nextId++;
	}
	
	/**
	 * Name Getter
	 * 
	 * @return Station Name
	 * 
	 * 
	 */

	
	public String getName() {
		return name;
	}
	
	/**
	 * Name Setter
	 * 
	 * @param Name 
	 * @throws Exception, Station's name cannot be longer than 50 characters 
	 * 
	 * 
	 */

	
	public void setName(String name) throws Exception {
		if (name.length() > 50) {
			throw new Exception("[ERROR] Station's name cannot be longer than 50 characters");
		} else {
			this.name = name;
		}
	}
	
	/**
	 * Address Getter
	 * 
	 * @return Address
	 * 
	 */

	public Address getAddress() {
		return this.address;
	}
	
	/**
	 * 
	 * 
	 * Address Setter
	 * @param Street	
	 * @param Latitude
	 * @param Longitude	
	 * 
	 * 
	 */

	public void setAddress(String street, double latitude, double longitude) throws Exception {
		this.address = new Address(street, latitude, longitude);
	}


	/**
	 * Cap Getter
	 * 
	 * @return Next Id
	 * 
	 * 
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
		} 
		
		else if (this.isEmpty()== false){
			throw new Exception("[ERROR] Station is not empty, therefore you cannot change its capacity");
		
		} else {
			
			this.capacity = capacity;
			bikes = new Bike[capacity];
		}
	}

	
	
	/**
	 * Bikes Getter
	 * 
	 * 
	 * @return Bikes
	 * 
	 * 
	 */
	
	
	public Bike [] getBikes() {
		return bikes;
	}
	/**
	 * IsFull 
	 * 
	 * 
	 * @return Boolean
	 * 
	 * 
	 */


	public Boolean isFull() {
		
		for (int i = 0; i<= capacity;i++) {
			if (bikes[i] == null) {
				return false;
			}
		}
		return true;
		
		
	}
	
	/**
	 * IsEmpty
	 * 
	 * 
	 * @return Boolean
	 * 
	 * 
	 */
	
	public Boolean isEmpty() {
			
		for (int i = 0; i<= capacity;i++) {
			if (bikes[i] == null) {
				return true;
			}
		}
		return false;
		
	
	}
	
	/**
	 * First Free Parking Lot 
	 * 
	 * 
	 * @return Index
	 * 
	 * 
	 */
	
	public int getFirstFreeParkingLot() {
		
		if (isFull()) {
			return -1;
		}
		for (int i = 0; i<= capacity;i++) {
			
			if (bikes[i] == null) {
				return i;
			}
		}
		
		return -1;
	
	
	}
	
	/**
	 * Free Parking Lots
	 * 
	 * 
	 * @return Counter
	 * 
	 * 
	 */
	
	
	public int getNumFreeParkingLots() {
		
		int j = 0;
		
		for (int i = 0; i< capacity;i++) {
			
			if (bikes[i] == null) {
				
				j = j + 1 ;
				
			}
			
		}
		return j;
		
	}
	
	/**
	 * Parking Lot By Bike
	 * 
	 * @param Bike
	 * @return Index
	 * 
	 * 
	 */
	
	public int getParkingLotByBike(Bike b) {
		
		for (int i = 0; i < capacity; i++) {
			if(bikes[i] == b) 
				
				return i;
		}
		return -1;
	}
	/**
	 * Add a Bike
	 * 
	 * @param Bike
	 * 
	 * @throws Exception when Bike is null 
	 * @throws Exception when Station is full 
	 * @throws Exception when bike is already in the Station
	 */
	
	public void addBike(Bike b) throws Exception {
		
			if (b == null) {
				throw new Exception("[ERROR] The bike cannot be null");
				
			}
			
			if (getParkingLotByBike(b) != -1) {
				throw new Exception("[ERROR] This bike is already in this station");
				
			}
			
			if (isFull()) {
				throw new Exception("[ERROR] This station is full");
				
			}
			
	
			bikes[getFirstFreeParkingLot()] = b;
			
			b.setStation(this);
		
	}	
	
	/**
	 * Remove a Bike
	 * 
	 * 
	 * @param Bike 
	 * @throws Exception when the Bike does not exist in this Station
	 * 
	 */
	
	public void removeBike(Bike bike) throws Exception {
		
		if(getParkingLotByBike(bike) == -1) {
			
		throw new Exception("[ERROR] This bike does not exist in this station");
		}
		
		bikes[getParkingLotByBike(bike)] = null;
		
		bike.setStation(null);
	}
	
	
	
}	
