package com.daugherty.elevatorsystem.model;

public class Call {
	private int id;
	private int callTime;
	private int startFloor;
	private int endFloor;
	private int endTime;
	private int state;
	public static final int INACTIVE = 0;
	public static final int WAITING = 1;
	public static final int SCHEDULED = 2;
	public static final int IN_TRANSIT = 3;
	public static final int COMPLETE = 4;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCallTime() {
		return callTime;
	}
	public void setCallTime(int callTime) {
		this.callTime = callTime;
	}
	public int getStartFloor() {
		return startFloor;
	}
	public void setStartFloor(int startFloor) {
		this.startFloor = startFloor;
	}
	public int getEndFloor() {
		return endFloor;
	}
	public void setEndFloor(int endFloor) {
		this.endFloor = endFloor;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getTripTime() {
		return endTime - callTime;
	}
	public boolean isInactive() {
		return state == INACTIVE;
	}
	public boolean isWaiting() {
		return state == WAITING;
	}
	public boolean isComplete() {
		return state == COMPLETE;
	}
	public boolean isInTransit() {
		return state == IN_TRANSIT;
	}
	public boolean isScheduled() {
		return state == SCHEDULED;
	}
	
	
}
