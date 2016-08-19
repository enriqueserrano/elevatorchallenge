package com.daugherty.elevatorsystem.model;

import java.util.ArrayList;

public class Elevator {
	private int id;
	private int state;
	private int capacity;
	private int locationFloor;
	private int destinationFloor;
	private ArrayList<Call> passengers;
	private ArrayList<Call> scheduledPassengers;
	private final int IDLE = 0;
	private final int DOOR_OPENING = 2;
	private final int DOOR_CLOSING = 3;
	private final int MOVING_UP = 4;
	private final int MOVING_DOWN = 5;
	private int timeInCurrentState;

	public Elevator() {
		passengers = new ArrayList<Call>();
		scheduledPassengers = new ArrayList<Call>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getLocationFloor() {
		return locationFloor;
	}
	public void setLocationFloor(int locationFloor) {
		this.locationFloor = locationFloor;
	}
	public int getDestinationFloor() {
		return destinationFloor;
	}
	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}
	public ArrayList<Call> getPassengers() {
		return passengers;
	}
	public void setPassengers(ArrayList<Call> passengers) {
		this.passengers = passengers;
	}
	public ArrayList<Call> getScheduledPassengers() {
		return scheduledPassengers;
	}
	public void setScheduledPassengers(ArrayList<Call> scheduledPassengers) {
		this.scheduledPassengers = scheduledPassengers;
	}
	public boolean isIdle() {
		return state == IDLE;
	}
	public boolean isDoorOpening() {
		return state == DOOR_OPENING;
	}
	public boolean isDoorClosing() {
		return state == DOOR_CLOSING;
	}
	public boolean isMovingUp() {
		return state == MOVING_UP;
	}
	public boolean isMovingDown() {
		return state == MOVING_DOWN;
	}
	public int getTimeInCurrentState() {
		return timeInCurrentState;
	}
	public void setTimeInCurrentState(int timeInCurrentState) {
		this.timeInCurrentState = timeInCurrentState;
	}

	public int capacityAtFuturePickup(Call call) {
		// start with current passenger count
		int futureCapacity = passengers.size();
		// add - calls we pickup before this potential call
		for (int i=0; i < scheduledPassengers.size(); i++) {
			int schedStartFloor = scheduledPassengers.get(i).getStartFloor();
			int schedEndFloor = scheduledPassengers.get(i).getEndFloor();

			if (schedStartFloor < locationFloor && schedStartFloor >= call.getStartFloor()) {	// going down
				if (!(schedEndFloor <= schedStartFloor && schedEndFloor >= call.getStartFloor())) {
					futureCapacity++;
				}
			} else if (schedStartFloor > locationFloor && schedStartFloor <= call.getStartFloor()) { // going up
				if (!(schedEndFloor >= schedStartFloor && schedEndFloor <= call.getStartFloor())) {
					futureCapacity++;
				}
			}
		}
		// subtract - calls we drop off before this potential call
		for (int i=0; i < passengers.size(); i++) {
			int schedEndFloor = passengers.get(i).getEndFloor();
			if (!(schedEndFloor <= locationFloor && schedEndFloor >= call.getStartFloor())) {
				futureCapacity--;
			} else if (!(schedEndFloor >= locationFloor && schedEndFloor <= call.getStartFloor())) {
				futureCapacity--;
			}
		}
		return futureCapacity;
	}

	public void updateState() {
		// TODO
	}
}