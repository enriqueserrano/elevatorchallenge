package com.daugherty.elevatorsystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stop {

    private int stopId;
    private int elevatorId;
    private int floor;
    private int[] pickup;
    private int[] dropoff;

    @JsonCreator
    public Stop(@JsonProperty("stopId") int stopId, @JsonProperty("elevatorId") int elevatorId,
            @JsonProperty("floor") int floor, @JsonProperty("pickup") int[] pickup,
            @JsonProperty("dropoff") int[] dropoff) {
        this.stopId = stopId;
        this.elevatorId = elevatorId;
        this.floor = floor;
        this.pickup = pickup;
        this.dropoff = dropoff;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int[] getPickup() {
        return pickup;
    }

    public void setPickup(int[] pickup) {
        this.pickup = pickup;
    }

    public int[] getDropoff() {
        return dropoff;
    }

    public void setDropoff(int[] dropoff) {
        this.dropoff = dropoff;
    }

}
