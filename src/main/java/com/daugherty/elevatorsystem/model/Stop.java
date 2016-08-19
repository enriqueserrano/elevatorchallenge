package com.daugherty.elevatorsystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stop {

    private int stopId;
    private int elevatorId;
    private int floor;
    private ArrayList<Integer> pickup;
    private ArrayList<Integer> dropoff;

    @JsonCreator
    public Stop(@JsonProperty("stopId") int stopId, @JsonProperty("elevatorId") int elevatorId,
            @JsonProperty("floor") int floor, @JsonProperty("pickup") ArrayList<Integer> pickup,
            @JsonProperty("dropoff") ArrayList<Integer> dropoff) {
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

    public ArrayList<Integer> getPickup() {
        return pickup;
    }

    public void setPickup(ArrayList<Integer> pickup) {
        this.pickup = pickup;
    }

    public ArrayList<Integer> getDropoff() {
        return dropoff;
    }

    public void setDropoff(ArrayList<Integer> dropoff) {
        this.dropoff = dropoff;
    }

}
