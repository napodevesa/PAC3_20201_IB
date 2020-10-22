package edu.uoc.pac3.enums;

public enum Direction {

	RIGHT(0),
	UP(90),
	LEFT(180),
	DOWN(270);
	
	

	private int angle;

	private Direction(int angle) {
		this.angle = angle;
	}
	
	public int getAngle() {
		return this.angle;
	}
	
	@Override
	public String toString() {
		return "You are moving " + this.name();
	}
	
	
	public static Direction getDirection(int angle) {   	 
		
		while (angle >= 360) {
			angle = angle - 360;
		}	
		
			if (angle == 0 || angle > 315  && angle < 45) {
				return RIGHT;
			}
			
			if (angle == 90 || angle > 45 && angle < 135) {
				return UP;
			}
			
			if (angle == 180 || angle > 135 && angle < 225){
				return LEFT;
			}
			
			if (angle == 270 || angle > 225 && angle < 315) {
				return DOWN;
			}
		

		
		return null;
	
	
	}
	
	

}	