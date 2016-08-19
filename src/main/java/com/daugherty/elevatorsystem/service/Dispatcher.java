package com.daugherty.elevatorsystem.service;

import com.daugherty.elevatorsystem.model.*;
import java.util.ArrayList;
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

        final Solution outputSolution = new Solution();

        // primary while loop - iterate once per second
        while (!elevatorSystem.isAllCallsComplete()) {

            // TODO
            // execute any drop offs and pickups
            for (int i = 0; i < elevatorSystem.getElevators().size(); i++) {
                final Elevator elevator = elevatorSystem.getElevators().get(i);
                // TODO check that people could still get in before the door completely closes
                if((elevator.getState() == Elevator.DOOR_OPENING)
                        && (elevator.getTimeInCurrentState() == 1)) {

                    final ArrayList<Integer> dropoffIds = new ArrayList<Integer>();

                    final ArrayList<Call> currentPassengers = elevator.getPassengers();
                    for (int j = 0; j < currentPassengers.size(); j++) {
                        final Call currentPassenger = currentPassengers.get(j);
                        if(currentPassenger.getEndFloor() == elevator.getLocationFloor()) {
                            // Remove from waiting calls
                            elevatorSystem.removePassengerFromWaitingCalls(currentPassenger);
                            // Update all calls
                            elevatorSystem.updateCalls(currentPassenger, currentSeconds);
                            // Track the stop
                            dropoffIds.add(currentPassenger.getId());
                        }
                    }

                    for (int j = 0; j < dropoffIds.size(); j++) {
                     // Remove dropoffs from passenger list
                     final Integer currentDropoffId = dropoffIds.get(j);
                     elevator.removePassenger(currentDropoffId);
                        // Add dropoff to stop
                    }


                    final Stop elevatorStop = new Stop();
                    elevatorStop.setDropoff(dropoffIds);
                    // TODO  verify that Stop is not empty before pushing that to the solution
                    // TODO verify that the pickup AND stop aren't empty before pushing that to the solution

                }
            }

            // TODO continue -- increment total time at each drop off



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
