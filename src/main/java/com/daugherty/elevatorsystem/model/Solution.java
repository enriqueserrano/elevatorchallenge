package com.daugherty.elevatorsystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Solution {

    private int challengeId;
    private ArrayList<Stop> stops;

    @JsonCreator
    public Solution(@JsonProperty("challengeId") int id, @JsonProperty("stops") ArrayList<Stop> stops) {
        this.challengeId = id;
        this.stops = stops;
    }

    public Solution() {
        this.stops = new ArrayList<Stop>();
    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public ArrayList<Stop> getStops() {
        return stops;
    }

    public void setStops(ArrayList<Stop> stops) {
        this.stops = stops;
    }

}
