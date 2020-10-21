package edu.uoc.pac3;

/**
 * Station Class
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
	
	private Bike[] bikes = new Bike[capacity] ;
	
	
	
	 
    
	/**
	 * Constructor without parameters 
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

	
	public Station(String name, String street, double latitude, double longitude, int capacity ) throws Exception {

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
	 * Id Setter.
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
	 * next id ++
	 */

	
	private void plusId() {
		nextId++;
	}
	
	/**
	 * Name Getter.
	 * 
	 * @return name of Station
	 */

	
	public String getName() {
		return name;
	}
	
	/**
	 * Name setter.
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
	 * Cap Getter
	 * 
	 * @return nextId
	 */
	
	public int getCapacity() {
		return capacity;
	}
	

	/**
	 * Cap Setter
	 * 
	 * 
	 */


	public void setCapacity(int capacity) throws Exception {
		if (capacity <= 0) {
			throw new Exception("[ERROR] Station's capacity must be greater than 0");
		} 
		
		else if (!this.isEmpty()){
			throw new Exception("[ERROR] Station is not empty, therefore you cannot change its capacity");
		} else {
			this.capacity = capacity;
			bikes = new Bike[capacity];
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
	 * @param street	
	 * @param latitude
	 * @param longitude	
	 */

	public void setAddress(String street, double latitude, double longitude) throws Exception {
		this.address = new Address(street, latitude, longitude);
	}

	
	
	public Bike [] getBikes() {
		return bikes;
	}
	


	public Boolean isFull() {
		
		for (int i = 0; i<= capacity;i++) {
			if (bikes[i] == null) {
				return false;
			}
		}
		return true;
		
		
	}
	
	public Boolean isEmpty() {
			
		for (int i = 0; i<= capacity;i++) {
			if (bikes[i] == null) {
				return true;
			}
		}
		return false;
		
	
	}
	
	public int getFirstFreeParkingLot() {
		int i=0;
		if (isFull()) {
			return -1;
		}
		for (i = 0; i<= capacity;i++) {
			
			if (bikes[i] == null) {
				return i;
			}
		}
		
		return -1;
	
	
	}
	
	
	public int getNumFreeParkingLots() {
		
		int j = 0;
		
		for (int i = 0; i< capacity;i++) {
			
			if (bikes[i] == null) {
				
				j = j + 1 ;
				
			}
			
		}
		return j;
		
	}
	
	public int getParkingLotByBike(Bike b) {
			
			
			for (int i = 0; i < capacity; i ++) {
				
				if (bikes[i] == b) 
					
					return i;
			}
				
				
			return -1;
			
			
	}	
	
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
	 * Remove Bike
	 * @param Bike remove
	 * @throws Exception
	 */
	
	public void removeBike(Bike bike) throws Exception {
		if(getParkingLotByBike(bike) == -1) throw new Exception("[ERROR] This bike does not exist in this station");
		
		bikes[getParkingLotByBike(bike)] = null;
		
		bike.setStation(null);
	}
	
	
	
	
	
	
	
	
}	
