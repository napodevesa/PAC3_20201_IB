package edu.uoc.pac3;

public class Station {
	
	private int id;
	private static int nextId = 0;
	private String name = "Default";
	private int capacity = 24;
	

	
	public Station() {
		setId();
	}

	
	public Station(String name, String street, double latitude, double longitude, int capacity) throws Exception {

		setName(name);
		setCapacity(capacity);
		setId();
		
	}

	
	public int getId() {
		return id;
	}

	
	private void setId() {
		id = nextId;
		incNextId();
	}

	
	public static int getNextId() {
		return nextId;
	}

	
	private void incNextId() {
		nextId++;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) throws Exception {
		if (name.length() > 50) {
			throw new Exception("[ERROR] Station's name cannot be longer than 50 characters");
		} else {
			this.name = name;
		}
	}

	

	
	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) throws Exception {
		if (capacity <= 0) {
			throw new Exception("[ERROR] Station's capacity must be greater than 0");
		} else {
			this.capacity = capacity;
		}
	}


	public Address getAddress () {
		
	}


	public void setAddress(String street, double latitude, double longitude) throws Exception {
		
		
	}


	





}