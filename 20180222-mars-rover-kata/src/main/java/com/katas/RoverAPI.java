package com.katas;

public class RoverAPI {

	private Rover rover;

	public RoverAPI(Rover rover) {
		this.rover = rover;
	}

	public boolean handle(char[] commands) {
		rover.moveForward();
		return true;
	}
}
