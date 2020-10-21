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
	private static int nextId=0 ;
	/**
	 *last reparation
	 */
	private LocalDate lastReparation = null;
	
	private Station station;
	
	public Bike() {
		setId();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId() {
		this.id = nextId;
		incNextId();
		
	}
	
	
	public static int getNextId() {
		return nextId;
	}
	
	private void incNextId() {
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

	public void setStation(Station station) throws Exception {
		Station oldStation = this.station;
		
		//Assign it to the new station
		this.station = station;
		
		//If the bike hasn't been removed from the old station, remove it
		if(oldStation != null && oldStation.getParkingLotByBike(this) != -1) {
			oldStation.removeBike(this);
		}
		
		//If the bike hasn't been added to the new station, add it
		if(station != null && station.getParkingLotByBike(this) == -1) {
			station.addBike(this);
		}
	
	}
}