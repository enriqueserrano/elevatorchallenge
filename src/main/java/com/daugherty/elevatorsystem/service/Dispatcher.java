package com.daugherty.elevatorsystem.service;

import com.daugherty.elevatorsystem.model.Call;
import com.daugherty.elevatorsystem.model.ElevatorSystem;
import org.springframework.stereotype.Service;

import com.daugherty.elevatorsystem.model.Challenge;
import com.daugherty.elevatorsystem.model.Solution;

@Service
public class Dispatcher {

    private ElevatorSystem elevatorSystem;
    private int currentSeconds = 0;

    public Dispatcher () {

    }

    public Solution solveChallenge (Challenge challenge) {
        System.out.println("Solving challenge: " + challenge.getChallengeId());
        return new Solution();
    }

    public void start() {
        elevatorSystem = new ElevatorSystem();


        // primary while loop - iterate once per second
        while (!elevatorSystem.isAllCallsComplete()) {

            // update queue of waiting calls
            // loop through allCalls
            for (int i=0; i < elevatorSystem.getAllCalls().size(); i++) {
                // get anybody who calls for an elevator this second
                Call thisCall = elevatorSystem.getAllCalls().get(i);
                if (thisCall.getCallTime() == currentSeconds) {
                    elevatorSystem.getWaitingCalls().add(thisCall);
                }
            }

            // evaluate whether anybody is waiting for an elevator
            if (elevatorSystem.getWaitingCalls().size() >0) {
                // check if any waiting call are unscheduled, loop through them
                for (int k=0; k < elevatorSystem.getWaitingCalls().size(); k++) {

                    // if so, for each elevator
                    for (int j=0; j < elevatorSystem.getElevators().size(); j++) {
                        // check if future capacity can handle this call
                        //if (capacityAtFuturePickup() < elevatorSystem.getElevators().get(j).getCapacity()) {
                        // check the cost of adding this passenger
                        // also check the added cost to everybody else on the elevator
                        //}


                    }
                }
            }

            currentSeconds++;
        }

    }

}
