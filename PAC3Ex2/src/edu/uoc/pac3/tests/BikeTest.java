package edu.uoc.pac3.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac3.Bike;

@TestInstance(Lifecycle.PER_CLASS)

class BikeTest {

	Bike bike;
	LocalDate now;
	
	@BeforeAll
	void testBike() {
		try {
			bike = new Bike();
			now = LocalDate.now();
		} catch (Exception e) {
			e.printStackTrace();
			fail("testBike failed");
		}
	}

	@Test
	void testGetId() {
		assertEquals(0,bike.getId());
	}

	@Test
	void testGetNextId() {
		assertEquals(1,Bike.getNextId());
	}

	@Test
	void testGetLastReparation() {
		assertEquals(now,bike.getLastReparation());		
	}

	@Test
	void testSetLastReparation() {
		Exception ex = assertThrows(Exception.class, () -> bike.setLastReparation(LocalDate.of(3020, 1, 1)));
		assertEquals("[ERROR] Bike's reparation date cannot be greater than today",ex.getMessage());
		assertEquals(null,bike.getLastReparation());
		
		
		try{
			bike.setLastReparation(now);
			assertEquals(now,bike.getLastReparation());
		}catch(Exception e) {
			fail("testLastReparation failed");
		}		
	}
}
