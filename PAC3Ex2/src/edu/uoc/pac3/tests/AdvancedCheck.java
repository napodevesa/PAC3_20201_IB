package edu.uoc.pac3.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.Order;

import edu.uoc.pac3.Bike;
import edu.uoc.pac3.Station;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class AdvancedCheck {
	Station station1, station2;
	Bike bike1, bike2;
	
	@BeforeAll
	void init(){
		try {
			station1 = new Station();		
			station2 = new Station("Poblenou 1", "Rambla Poblenou, 156", 34.5, 89, 10);
			bike1 = new Bike();
			bike2 = new Bike();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Init failed");
		}
	}

	@Test
	@Order(1)
	void testIntegration1() {
		try {
			station1.addBike(bike1);		
			assertEquals(0,station1.getParkingLotByBike(bike1));
			assertEquals(23,station1.getNumFreeParkingLots());
			assertEquals(1,station1.getFirstFreeParkingLot());
			assertEquals(bike1,station1.getBikes()[station1.getParkingLotByBike(bike1)]);
			assertEquals(station1,bike1.getStation());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration1 failed");
		}
	}
	
	@Test
	@Order(2)
	void testIntegration2()  {		
		try{
			bike1.setStation(station1);
			Exception ex = assertThrows( Exception.class,() -> station1.addBike(bike1));
			assertEquals("[ERROR] This bike is already in this station", ex.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			fail("Integration2 failed");
		}		
	}
	
	
	@Test
	@Order(3)
	void testIntegration3() {
		try {
			bike1.setStation(null);
			assertEquals(true,station1.isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration3 failed");
		}		
	}
	
	@Test
	@Order(4)
	void testIntegration4() {	
		try {
			bike1.setStation(station1);
			assertEquals(0,station1.getParkingLotByBike(bike1));
			assertEquals(23,station1.getNumFreeParkingLots());
			assertEquals(1,station1.getFirstFreeParkingLot());
			assertEquals(bike1,station1.getBikes()[station1.getParkingLotByBike(bike1)]);
			assertEquals(station1,bike1.getStation());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration4 failed");
		}		
	}
	
	@Test
	@Order(5)
	void testIntegration5() {		
		try {
			station1.removeBike(bike1);
			assertEquals(true,station1.isEmpty());
			assertEquals(null,bike1.getStation());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration5 failed");
		}		
	}
	
	@Test
	@Order(6)
	void testIntegration6() {		
		try {
			station1.addBike(bike2);
			assertEquals(-1,station1.getParkingLotByBike(bike1));
			assertEquals(0,station1.getParkingLotByBike(bike2));
			assertEquals(23,station1.getNumFreeParkingLots());
			assertEquals(1,station1.getFirstFreeParkingLot());
			assertEquals(bike2,station1.getBikes()[station1.getParkingLotByBike(bike2)]);
			assertEquals(station1,bike2.getStation());
			assertEquals(null,bike1.getStation());
			
			Exception ex = assertThrows( Exception.class,() -> station1.addBike(null));
			assertEquals("[ERROR] The bike cannot be null", ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration6 failed");
		}		
	}
	
	@Test
	@Order(7)
	void testIntegration7() {
		try{
			bike1.setStation(station2);
			bike2.setStation(station2);
			assertEquals(0,station2.getParkingLotByBike(bike1));
			assertEquals(1,station2.getParkingLotByBike(bike2));
			assertEquals(24,station1.getNumFreeParkingLots());
			assertEquals(8,station2.getNumFreeParkingLots());
			assertEquals(0,station1.getFirstFreeParkingLot());
			assertEquals(true,station1.isEmpty());
			assertEquals(2,station2.getFirstFreeParkingLot());
			assertEquals(bike1,station2.getBikes()[station2.getParkingLotByBike(bike1)]);
			assertEquals(bike2,station2.getBikes()[station2.getParkingLotByBike(bike2)]);
			assertEquals(station2,bike1.getStation());
			assertEquals(station2,bike2.getStation());
		}catch(Exception e) {
			e.printStackTrace();
			fail("Integration7 failed");
		}	
	}
	
	@Test
	@Order(8)
	void testIntegration8() {
		try{
			station2.removeBike(bike2);
			station2.removeBike(bike1);
			assertEquals(null,bike1.getStation());
			assertEquals(null,bike2.getStation());
			assertEquals(true,station1.isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
			fail("Integration8 failed");
		}	
	}
}
