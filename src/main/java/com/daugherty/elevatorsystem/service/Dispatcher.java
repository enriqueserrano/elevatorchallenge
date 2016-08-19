package com.daugherty.elevatorsystem.service;

import com.daugherty.elevatorsystem.model.*;
import org.springframework.stereotype.Service;

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

        // TODO - import data, assign constants to System object



        // primary while loop - iterate once per second
        while (!elevatorSystem.isAllCallsComplete()) {

            // TODO
            // execute any drop offs and pickups

            // increment total time at each drop off



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
            if (elevatorSystem.getWaitingCalls().size() > 0) {
                // check if any waiting call are unscheduled, loop through them
                for (int k=0; k < elevatorSystem.getWaitingCalls().size(); k++) {
                    Call evalCall = elevatorSystem.getWaitingCalls().get(k);

                    int lowestCost = 0;
                    int bestElevator = 0;

                    // if so, for each elevator
                    for (int j=0; j < elevatorSystem.getElevators().size(); j++) {
                        // check if future capacity can handle this call
                        Elevator evalElevator = elevatorSystem.getElevators().get(j);
                        int thisCost = -1;
                        if (evalElevator.capacityAtFuturePickup(evalCall) < evalElevator.getCapacity()) {
                            // check the cost of adding this passenger
                            thisCost = elevatorSystem.costOfNewPassenger(evalCall, evalElevator);

                            // also check the added cost to everybody else on the elevator


                        }
                        if (thisCost < lowestCost && thisCost >= 0) {
                            lowestCost = thisCost;
                            bestElevator = j;
                        }
                    }

                    // TODO - pick the best elevator for this call, and update scheduledpassengers


                }
            }

            // TODO - update each elevator's state / time in state, direction, etc.
            for (int j=0; j < elevatorSystem.getElevators().size(); j++) {
                elevatorSystem.getElevators().get(j).updateState();
            }


            currentSeconds++;
        }
    }
}
