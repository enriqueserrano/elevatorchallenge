package com.daugherty.elevatorsystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Challenge {

    private int challengeId;
    private boolean isActive;
    private int maxFloor;
    private int numberOfElevators;
    private int maxCapacity;
    private int secondsPerfloor;
    private int secondsPerfloorOverTenfloors;
    private int timeToOpenDoor;
    private int timeToCloseDoor;

    private Call[] calls;

    @JsonCreator
    public Challenge(@JsonProperty("challengeId") int challengeId,
            @JsonProperty("isActive") boolean isActive,
            @JsonProperty("maxFloor") int maxFloor,
            @JsonProperty("numberOfElevators") int numberOfElevators,
            @JsonProperty("maxCapacity") int maxCapacity,
            @JsonProperty("secondsPerfloor") int secondsPerfloor,
            @JsonProperty("secondsPerfloorOverTenFloors") int secondsPerfloorOverTenfloors,
            @JsonProperty("timeToOpenDoor") int timeToOpenDoor,
            @JsonProperty("timeToCloseDoor") int timeToCloseDoor,
            @JsonProperty("calls") Call[] calls) {
        this.challengeId = challengeId;
        this.isActive = isActive;
        this.maxFloor = maxFloor;
        this.numberOfElevators = numberOfElevators;
        this.maxCapacity = maxCapacity;
        this.secondsPerfloor = secondsPerfloor;
        this.secondsPerfloorOverTenfloors = secondsPerfloorOverTenfloors;
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

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getNumberOfElevators() {
        return numberOfElevators;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getSecondsPerfloor() {
        return secondsPerfloor;
    }

    public int getSecondsPerfloorOverTenfloors() {
        return secondsPerfloorOverTenfloors;
    }

    public int getTimeToOpenDoor() {
        return timeToOpenDoor;
    }

    public int getTimeToCloseDoor() {
        return timeToCloseDoor;
    }

    public Call[] getCalls() {
        return calls;
    }

    public void setCalls(Call[] calls) {
        this.calls = calls;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public void setNumberOfElevators(int numberOfElevators) {
        this.numberOfElevators = numberOfElevators;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setSecondsPerfloor(int secondsPerfloor) {
        this.secondsPerfloor = secondsPerfloor;
    }

    public void setSecondsPerfloorOverTenfloors(int secondsPerfloorOverTenfloors) {
        this.secondsPerfloorOverTenfloors = secondsPerfloorOverTenfloors;
    }

    public void setTimeToOpenDoor(int timeToOpenDoor) {
        this.timeToOpenDoor = timeToOpenDoor;
    }

    public void setTimeToCloseDoor(int timeToCloseDoor) {
        this.timeToCloseDoor = timeToCloseDoor;
    }

}
