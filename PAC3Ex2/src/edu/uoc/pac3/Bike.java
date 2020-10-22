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
	
	/**
	 * Id Getter
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
	 */

	public void setId() {
		this.id = nextId;
		plus();
		
	}
	/**
	 * NextID Getter
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
	 * Last Reparation Getter
	 * 
	 * @return Last Reparation
	 */

	
	public LocalDate getLastReparation() {
		return lastReparation;
	}
	/**
	 * LastRepatation Setter
	 * 
	 * @throws Exceptions, Bike's reparation date cannot be greater than today
	 */

	public void setLastReparation(LocalDate date) throws Exception {
		
		if (date.compareTo(LocalDate.now()) > 0) {
			throw new Exception("[ERROR] Bike's reparation date cannot be greater than today");
	
		}else {
	
			this.lastReparation = date;
		}
	
	}
	
	/**
	 * Station Getter
	 * 
	 * @return Station
	 */
	public Station getStation() {
		return station;
		
	}
	
	/**
	 * Station Setter
	 * 
	 * @throws Exceptions
	 */

	public void setStation(Station station) throws Exception {
		
		Station s = this.station;
		
		this.station = station;
		
	
		if(s != null && s.getParkingLotByBike(this) != -1) {
			s.removeBike(this);
		}
		
		
		if(station != null && station.getParkingLotByBike(this) == -1) {
			station.addBike(this);
		}
	
	}
}