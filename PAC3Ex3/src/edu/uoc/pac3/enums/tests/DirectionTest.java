package edu.uoc.pac3.enums.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uoc.pac3.enums.Direction;

class DirectionTest {

	private Direction d;
	
	@Test
	void testGetAngle() {
		d = Direction.RIGHT;		
		assertEquals(0,d.getAngle());
		
		d = Direction.UP;		
		assertEquals(90,d.getAngle());
		
		d = Direction.LEFT;		
		assertEquals(180,d.getAngle());
		
		d = Direction.DOWN;		
		assertEquals(270,d.getAngle());
	}
	
	@Test
	void testToString() {
		d = Direction.RIGHT;		
		assertEquals("You are moving RIGHT",d.toString());
		
		d = Direction.UP;		
		assertEquals("You are moving UP",d.toString());
		
		d = Direction.LEFT;		
		assertEquals("You are moving LEFT",d.toString());
		
		d = Direction.DOWN;		
		assertEquals("You are moving DOWN",d.toString());
	}
	
	@Test
	void testGetDirection() {
		//4 directions
		assertEquals(Direction.RIGHT,Direction.getDirection(0));
		assertEquals(Direction.UP,Direction.getDirection(90));
		assertEquals(Direction.LEFT,Direction.getDirection(180));
		assertEquals(Direction.DOWN,Direction.getDirection(270));
		
		//Limit or overflowed directions
		assertEquals(Direction.RIGHT,Direction.getDirection(360));
		assertEquals(Direction.RIGHT,Direction.getDirection(720));
		assertEquals(Direction.DOWN,Direction.getDirection(630));
		assertEquals(null,Direction.getDirection(-90));
		
		assertEquals(Direction.DOWN,Direction.getDirection(273));
		assertEquals(Direction.UP,Direction.getDirection(92));
		assertEquals(Direction.UP,Direction.getDirection(115));
		assertEquals(Direction.LEFT,Direction.getDirection(165));
	}

}
