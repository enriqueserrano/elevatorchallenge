package com.daugherty.elevatorsystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Challenge {

    private int challengeId;
    private boolean isActive;
    private int maxfloor;
    private int minfloor;
    private int numberOfElevators;
    private int maxCapacity;
    private int secondsPerFloor;
    private int secondsPerFloorOverTenFloors;
    private int timeToOpenDoor;
    private int timeToCloseDoor;

    private ArrayList<IncomingCall> calls;

    @JsonCreator
    public Challenge(@JsonProperty("challengeId") int challengeId,
            @JsonProperty("isActive") boolean isActive,
            @JsonProperty("maxfloor") int maxfloor,
            @JsonProperty("minfloor") int minfloor,
            @JsonProperty("numberOfElevators") int numberOfElevators,
            @JsonProperty("maxCapacity") int maxCapacity,
            @JsonProperty("secondsPerFloor") int secondsPerFloor,
            @JsonProperty("secondsPerfloorOverTenFloors") int secondsPerFloorOverTenFloors,
            @JsonProperty("timeToOpenDoor") int timeToOpenDoor,
            @JsonProperty("timeToCloseDoor") int timeToCloseDoor,
            @JsonProperty("calls") ArrayList<IncomingCall> calls) {
        this.challengeId = challengeId;
        this.isActive = isActive;
        this.maxfloor = maxfloor;
        this.minfloor = minfloor;
        this.numberOfElevators = numberOfElevators;
        this.maxCapacity = maxCapacity;
        this.secondsPerFloor = secondsPerFloor;
        this.secondsPerFloorOverTenFloors = secondsPerFloorOverTenFloors;
        this.timeToOpenDoor = timeToOpenDoor;
        this.timeToCloseDoor = timeToCloseDoor;
        this.calls = calls;
    }

    public int getChallengeId() {
        return challengeId;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getMaxfloor() {
        return maxfloor;
    }

    public int getMinfloor() { return minfloor; }

    public int getNumberOfElevators() {
        return numberOfElevators;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getSecondsPerFloor() {
        return secondsPerFloor;
    }

    public int getSecondsPerFloorOverTenFloors() {
        return secondsPerFloorOverTenFloors;
    }

    public int getTimeToOpenDoor() {
        return timeToOpenDoor;
    }

    public int getTimeToCloseDoor() {
        return timeToCloseDoor;
    }

    public ArrayList<IncomingCall> getCalls() {
        return calls;
    }

    public void setCalls(ArrayList<IncomingCall> calls) {
        this.calls = calls;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setMaxfloor(int maxFloor) {
        this.maxfloor = maxFloor;
    }

    public void setMinfloor(int minfloor) { this.minfloor = minfloor; }


    public void setNumberOfElevators(int numberOfElevators) {
        this.numberOfElevators = numberOfElevators;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setSecondsPerFloor(int secondsPerFloor) {
        this.secondsPerFloor = secondsPerFloor;
    }

    public void setSecondsPerFloorOverTenFloors(int secondsPerFloorOverTenFloors) {
        this.secondsPerFloorOverTenFloors = secondsPerFloorOverTenFloors;
    }

    public void setTimeToOpenDoor(int timeToOpenDoor) {
        this.timeToOpenDoor = timeToOpenDoor;
    }

    public void setTimeToCloseDoor(int timeToCloseDoor) {
        this.timeToCloseDoor = timeToCloseDoor;
    }

}
