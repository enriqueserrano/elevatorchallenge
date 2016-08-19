package com.daugherty.elevatorsystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Call {

    private int callId;
    private int callTime;
    private int startfloor;
    private int endfloor;

    @JsonCreator
    public Call(@JsonProperty("callid") int callId, @JsonProperty("callTime") int callTime,
            @JsonProperty("startfloor") int startfloor, @JsonProperty("endfloor") int endfloor) {
        this.callId = callId;
        this.callTime = callTime;
        this.startfloor = startfloor;
        this.endfloor = endfloor;
    }

    public int getCallId() {
        return callId;
    }

    public int getCallTime() {
        return callTime;
    }

    public int getStartfloor() {
        return startfloor;
    }

    public int getEndfloor() {
        return endfloor;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }

    public void setStartfloor(int startFloor) {
        this.startfloor = startFloor;
    }

    public void setEndfloor(int endFloor) {
        this.endfloor = endFloor;
    }


}
