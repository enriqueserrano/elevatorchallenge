package com.daugherty.elevatorsystem.model;

import java.util.ArrayList;

public class Elevator {
	private int id;
	private int state;
	private int capacity;
	private int locationFloor;
	private int destinationFloor;
	private ArrayList<Integer> passengers;
	private final int IDLE = 0;
	private final int LOADING = 1;
	private final int DOOR_OPENING = 2;
	private final int DOOR_CLOSING = 3;
	private final int MOVING_UP = 4;
	private final int MOVING_DOWN = 5;
	
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
	public ArrayList<Integer> getPassengers() {
		return passengers;
	}
	public void setPassengers(ArrayList<Integer> passengers) {
		this.passengers = passengers;
	}
	public boolean isIdle() {
		return state == IDLE;
	}
	public boolean isLoading() {
		return state == LOADING;
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
	
	
}
