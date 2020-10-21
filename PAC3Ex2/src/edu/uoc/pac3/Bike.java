package edu.uoc.pac3;

import java.time.LocalDate;

/**
 * Address Station
 * 
 * @author Napoleón Devesa Dalio - ndev
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
	private static int nextId = 0;
	/**
	 *last reparation
	 */
	private LocalDate lastReparation = null;
	
	private Station station;
	
	
	/**
	 * Constructor without parameters 
	 * 
	 * 
	 */

	public Bike() {
		this( 0, null);
	}



	public Bike( int j, LocalDate object) {
		// TODO Auto-generated constructor stub
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
	
	
