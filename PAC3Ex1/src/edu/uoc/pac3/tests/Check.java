package edu.uoc.pac3.tests;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import edu.uoc.pac3.Station;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class Check {
		
	Station s;		
	
	@BeforeAll
	void init() {
		 try{
			 s = new Station("Poblenou 1", "Rambla Poblenou, 156", 34.5, 89, 10);
		 }catch(Exception e) {
				fail("Parameterized constructor failed");
		}
	}
	
	@Test
	@Order(1)
	void testStation() {
		try{
			Station station = new Station();
			assertEquals(1,station.getId());
			assertEquals("Default",station.getName());
			assertEquals("Sesame Street",station.getAddress().getStreet());
			assertEquals(0,station.getAddress().getLatitude());
			assertEquals(0,station.getAddress().getLongitude());
			assertEquals(24,station.getCapacity());
		}catch(Exception e) {
			fail("Default constructor failed");
		}		
	}

	@Test
	@Order(2)
	void testStationStringStringDoubleDoubleInt() {		
		Exception ex = assertThrows(Exception.class, () ->new Station("Poblenou 1 asfdm�lak �lasdkf �lsak dskf�lkasd�l fa dfasf adsf", "Rambla Poblenou, 156", 34.5, 82, 10)); 
		assertEquals("[ERROR] Station's name cannot be longer than 50 characters", ex.getMessage());
		
		ex = assertThrows(Exception.class, () ->new Station("Poblenou 1", "Rambla Poblenou, 156", -94.5, 82, 10));
		assertEquals("[ERROR] Address' latitude must be in range [-90,+90]", ex.getMessage());
		
		ex = assertThrows(Exception.class, () ->new Station("Poblenou 1", "Rambla Poblenou, 156", 34.5, 182, 10));
		assertEquals("[ERROR] Address' longitude must be in range [-180,+180]", ex.getMessage());
		
		ex = assertThrows(Exception.class, () ->new Station("Poblenou 1", "Rambla Poblenou, 156", 34.5, 82, -30));
		assertEquals("[ERROR] Station's capacity must be greater than 0", ex.getMessage());		
	}

	@Test
	@Order(3)
	void testGetId() {
		assertEquals(0,s.getId());		
	}

	@Test
	@Order(4)
	void testGetNextId() {
		assertEquals(2,Station.getNextId());
	}

	@Test
	@Order(5)
	void testGetName() {
		assertEquals("Poblenou 1",s.getName());		
	}

	@Test
	@Order(6)
	void testSetName() {
		try{
			s.setName("Horta 2");
			assertEquals("Horta 2",s.getName());
		}catch(Exception e) {
			fail("setName failed");
		}
		
		
		Exception ex = assertThrows(Exception.class, () ->	s.setName("ksa�lfka�k f k�alskf �ak�fdk sdfka�lkfd a�lskfd� lasdkf�lkaslf "));
		assertEquals("[ERROR] Station's name cannot be longer than 50 characters", ex.getMessage());
	}
	
	@Test
	@Order(7)
	void testGetAddress() {
		assertEquals("Rambla Poblenou, 156",s.getAddress().getStreet());
		assertEquals(34.5,s.getAddress().getLatitude());
		assertEquals(89,s.getAddress().getLongitude());
	}

	@Test
	@Order(8)
	void testGetStreet() {
		assertEquals("Rambla Poblenou, 156",s.getAddress().getStreet());	
	}

	@Test
	@Order(9)
	void testSetStreet() {
		s.getAddress().setStreet("Pla�a Eivissa");
		assertEquals("Pla�a Eivissa",s.getAddress().getStreet());
	}

	@Test
	@Order(10)
	void testGetLatitude() {		
		assertEquals(34.5,s.getAddress().getLatitude());		
	}

	@Test
	@Order(11)
	void testSetLatitude() {
		try{
			s.getAddress().setLatitude(50);
			assertEquals(50,s.getAddress().getLatitude());
		}catch(Exception e) {
			fail("setLatitude failed");
		}
		
		Exception ex = assertThrows(Exception.class, () ->	s.getAddress().setLatitude(91));
		assertEquals("[ERROR] Address' latitude must be in range [-90,+90]", ex.getMessage());
		
		
		ex = assertThrows(Exception.class, () ->	s.getAddress().setLatitude(-91));
		assertEquals("[ERROR] Address' latitude must be in range [-90,+90]", ex.getMessage());
	}

	@Test
	@Order(12)
	void testGetLongitude() {
		assertEquals(89,s.getAddress().getLongitude());		
	}

	@Test
	@Order(13)
	void testSetLongitude() {
		try{
			s.getAddress().setLongitude(150);
			assertEquals(150,s.getAddress().getLongitude());
		}catch(Exception e) {
			fail("setLongitude failed");
		}
		
		Exception ex = assertThrows(Exception.class, () ->	s.getAddress().setLongitude(181));
		assertEquals("[ERROR] Address' longitude must be in range [-180,+180]", ex.getMessage());
	
		ex = assertThrows(Exception.class, () ->	s.getAddress().setLongitude(-180.5));
		assertEquals("[ERROR] Address' longitude must be in range [-180,+180]", ex.getMessage());		
	}

	@Test
	@Order(14)
	void testGetCapacity() {
		assertEquals(10,s.getCapacity());
	}

	@Test
	@Order(15)
	void testSetCapacity() {
		try{
			s.setCapacity(15);
			assertEquals(15,s.getCapacity());
		}catch(Exception e) {
			fail("setCapacity failed");
		}
		
		Exception ex = assertThrows(Exception.class, () ->	s.setCapacity(0));
		assertEquals("[ERROR] Station's capacity must be greater than 0", ex.getMessage());
			
		
		ex = assertThrows(Exception.class, () ->	s.setCapacity(-10));
		assertEquals("[ERROR] Station's capacity must be greater than 0", ex.getMessage());		
	}
}