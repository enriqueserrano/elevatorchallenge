package com.daugherty.elevatorsystem.service;

import org.springframework.stereotype.Service;

import com.daugherty.elevatorsystem.model.Challenge;
import com.daugherty.elevatorsystem.model.Solution;

@Service
public class Dispatcher {

    public Dispatcher () {

    }

    public Solution solveChallenge (Challenge challenge) {
        System.out.println("Solving challenge: " + challenge.getChallengeId());
        return new Solution();
    }

}
