package com.daugherty.elevatorsystem.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ElevatorSystem {
	private ArrayList<Elevator> elevators;
	private ArrayList<Call> allCalls;
	private ArrayList<Call> waitingCalls;
	private int challengeId;
	private int secPerFloor;
	private int secPerFloorOver10;
	private int secOpenDoor;
	private int secCloseDoor;
	private int maxFloor;
	private int minFloor;
	private ArrayList<Stop> stops;

	public ArrayList<Elevator> getElevators() {
		return elevators;
	}
	public void setElevators(ArrayList<Elevator> elevators) {
		this.elevators = elevators;
	}
	public ArrayList<Call> getAllCalls() {
		return allCalls;
	}
	public void setAllCalls(ArrayList<Call> allCalls) {
		this.allCalls = allCalls;
	}
	public ArrayList<Call> getWaitingCalls() {
		return waitingCalls;
	}
	public void setWaitingCalls(ArrayList<Call> waitingCalls) {
		this.waitingCalls = waitingCalls;
	}
	public int getChallengeId() {
		return challengeId;
	}
	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}
	public int getSecPerFloor() {
		return secPerFloor;
	}
	public void setSecPerFloor(int secPerFloor) {
		this.secPerFloor = secPerFloor;
	}
	public int getSecPerFloorOver10() {
		return secPerFloorOver10;
	}
	public void setSecPerFloorOver10(int secPerFloorOver10) {
		this.secPerFloorOver10 = secPerFloorOver10;
	}
	public int getSecOpenDoor() {
		return secOpenDoor;
	}
	public void setSecOpenDoor(int secOpenDoor) {
		this.secOpenDoor = secOpenDoor;
	}
	public int getSecCloseDoor() {
		return secCloseDoor;
	}
	public void setSecCloseDoor(int secCloseDoor) {
		this.secCloseDoor = secCloseDoor;
	}
	public int getMaxFloor() {
		return maxFloor;
	}
	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
	}
	public int getMinFloor() {
		return minFloor;
	}
	public void setMinFloor(int minFloor) {
		this.minFloor = minFloor;
	}
	public ArrayList<Stop> getStops() {
		return stops;
	}
	public void setStops(ArrayList<Stop> stops) {
		this.stops = stops;
	}

	public boolean isAllCallsComplete() {
		boolean complete = true;
		for (int i=0; i<allCalls.size(); i++) {
			if (!allCalls.get(i).isComplete()) {
				complete = false;
				break;
			}
		}
		return complete;
	}

	public int costOfNewPassenger(Call call, Elevator elevator) {
		int travelCost = 0;
		// TODO
		// travel to the call
		int callStartFloor = call.getStartFloor();
		int locationFloor = elevator.getLocationFloor();
		travelCost = Math.abs(callStartFloor - locationFloor) * secPerFloor;

		// any open/closes/stops on the way to the call
		Set<Integer> stopSet = new HashSet<Integer>();
		for (int n=0; n < elevator.getPassengers().size(); n++) {
			Call passenger =  elevator.getPassengers().get(n);
			if (passenger.getEndFloor() < locationFloor &&
					passenger.getEndFloor() > callStartFloor) {
				stopSet.add(passenger.getEndFloor());
			} else if(passenger.getEndFloor() > locationFloor &&
					passenger.getEndFloor() < callStartFloor) {
				stopSet.add(passenger.getEndFloor());
			}
		}
		for (int n=0; n < elevator.getScheduledPassengers().size(); n++) {
			Call passenger =  elevator.getScheduledPassengers().get(n);
			int startFloor = passenger.getStartFloor();
			int endFloor = passenger.getEndFloor();
			if (startFloor < locationFloor && startFloor > callStartFloor) {
				stopSet.add(startFloor);
				if (endFloor < locationFloor && endFloor > callStartFloor) {
					stopSet.add(endFloor);
				} else if(endFloor > locationFloor && endFloor < callStartFloor) {
					stopSet.add(endFloor);
				}
			} else if(startFloor > locationFloor && startFloor < callStartFloor) {
				stopSet.add(startFloor);
				if (endFloor < locationFloor && endFloor > callStartFloor) {
					stopSet.add(endFloor);
				} else if(endFloor > locationFloor && endFloor < callStartFloor) {
					stopSet.add(endFloor);
				}
			}
		}
		travelCost += (stopSet.size() * (secOpenDoor + secCloseDoor));

		// open the door
		travelCost += secOpenDoor;
		// close the door
		travelCost += secCloseDoor;
		// travel to destination
		travelCost = Math.abs(callStartFloor - call.getEndFloor()) * secPerFloor;
		// any open/closes/stops on the way to the destination





		return travelCost;
	}
}
