package edu.uoc.pac3;

import java.time.LocalDate;

/**
 *Bike Class
 * 
 * @author NDevesa
 * @version 1
 */


public class Bike {
	/**
	 * The id of the Bike
	 */
	private int id;
	/**
	 * next Id
	 */
	private static int nextId ;
	/**
	 *last reparation
	 */
	private LocalDate lastReparation = null;
	
	private Station station;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = nextId;
		setNextId(nextId);
		
	}
	
	
	public static int getNextId() {
		return nextId + 1;
	}

	public static void setNextId(int nextId) {
		nextId++;
	}

	/**
	 * Constructor without parameters 
	 * 
	 * 
	 */

	public Bike() {
		this( 0, null);
	}

	/**
	 * Constructor with parameters 
	 * 
	 * 
	 */

	public Bike( int j, LocalDate object) {
		// TODO Auto-generated constructor stub
	}


	public LocalDate getLastReparation() {
		return lastReparation;
	}

	public void setLastReparation(LocalDate date) throws Exception {
		
		if (date.compareTo(LocalDate.now()) > 0) {
			throw new Exception("[ERROR] Bike's reparation date cannot be greater than today");
	
		}else {
	
			this.lastReparation = date;
		}
	
	}
	

	public Station getStation() {
		return station;
		
	}

	public void setStation(Station station) {
		this.station = station;
	}




	
	


}
	
	
