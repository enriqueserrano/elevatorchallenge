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
	public static final int IDLE = 0;
	public static final int DOOR_OPENING = 2;
	public static final int DOOR_CLOSING = 3;
	public static final int MOVING_UP = 4;
	public static final int MOVING_DOWN = 5;
	private int timeInCurrentState;

	public Elevator(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.state = Elevator.IDLE;
		this.capacity = capacity;
		this.locationFloor = 1;
		this.destinationFloor = 1;
		passengers = new ArrayList<Call>();
		scheduledPassengers = new ArrayList<Call>();
		this.timeInCurrentState = 0;
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

	public void updateState(ElevatorSystem elevatorSystem) {
		if (state == DOOR_OPENING && timeInCurrentState < elevatorSystem.getSecOpenDoor()) {
			timeInCurrentState++;
		} else if (state == DOOR_OPENING && timeInCurrentState == elevatorSystem.getSecOpenDoor()) {
			state = DOOR_CLOSING;
			timeInCurrentState = 0;
		} else if (state == DOOR_CLOSING && timeInCurrentState < elevatorSystem.getSecCloseDoor()) {
			timeInCurrentState++;
		} else if (state == DOOR_CLOSING && timeInCurrentState == elevatorSystem.getSecCloseDoor()) {
			if (passengers.size()==0 && scheduledPassengers.size()==0) {
				state = IDLE;
			} else {
				int nextDestination = getNextDestination();
				state = nextDestination<locationFloor ? MOVING_DOWN : MOVING_UP; 
			}
			timeInCurrentState = 0;
		} else if (state == IDLE) {
			if (passengers.size() > 0 && scheduledPassengers.size() > 0) {
				int nextDestination = getNextDestination();
				state = nextDestination<locationFloor ? MOVING_DOWN : MOVING_UP; 
			} 
			timeInCurrentState = 0;
		} else if (state == MOVING_DOWN && timeInCurrentState < elevatorSystem.getSecPerFloor()) {
			timeInCurrentState++;
		} else if (state == MOVING_DOWN && timeInCurrentState == elevatorSystem.getSecPerFloor()) {
			timeInCurrentState = 0;
			locationFloor--;
			if (locationFloor == destinationFloor) {
				state = DOOR_OPENING;
			}
		} else if (state == MOVING_UP && timeInCurrentState < elevatorSystem.getSecPerFloor()) {
			timeInCurrentState++;
		} else if (state == MOVING_UP && timeInCurrentState == elevatorSystem.getSecPerFloor()) {
			timeInCurrentState = 0;
			locationFloor++;
			if (locationFloor == destinationFloor) {
				state = DOOR_OPENING;
			}
		}
	}
	
	public int getNextDestination() {
		int closestFloor = 0;
		int bestDistance = -1;
		for (int i=0; i < passengers.size(); i++) {
			int distance = Math.abs(passengers.get(i).getEndFloor() - locationFloor);
			if (distance < bestDistance || bestDistance < 0) {
				bestDistance = distance;
				closestFloor = passengers.get(i).getEndFloor();
			}
		}
		for (int i=0; i < scheduledPassengers.size(); i++) {
			int distance = Math.abs(scheduledPassengers.get(i).getStartFloor() - locationFloor);
			if (distance < bestDistance || bestDistance < 0) {
				bestDistance = distance;
				closestFloor = scheduledPassengers.get(i).getStartFloor();
			}
		}
		return closestFloor;
	}

	public void removePassenger(int currentDropoffId) {
		ArrayList<Call> passengers = this.getPassengers();

		for(int i = 0; i < passengers.size(); i++) {
			Call currentPassenger = passengers.get(i);
			if(currentDropoffId == currentPassenger.getId()) {
				passengers.remove(i);
				return;
			}
		}
	}

	public void removeScheduledPassenger(int currentPickupId) {
		ArrayList<Call> scheduledPassengers = this.getScheduledPassengers();

		for(int i = 0; i < scheduledPassengers.size(); i++) {
			Call currentPassenger = scheduledPassengers.get(i);
			if(currentPickupId == currentPassenger.getId()) {
				scheduledPassengers.remove(i);
				return;
			}
		}
	}
}
