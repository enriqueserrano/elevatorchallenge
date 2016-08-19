package com.daugherty.elevatorsystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Solution {

    private int challengeId;
    private Stop[] stops;

    @JsonCreator
    public Solution(@JsonProperty("challengeId") int id, @JsonProperty("stops") Stop[] stops) {
        this.challengeId = id;
        this.stops = stops;
    }

    public Solution() {

    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public Stop[] getStops() {
        return stops;
    }

    public void setStops(Stop[] stops) {
        this.stops = stops;
    }

}
