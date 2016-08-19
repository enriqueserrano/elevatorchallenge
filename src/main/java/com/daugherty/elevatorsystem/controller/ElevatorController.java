package com.daugherty.elevatorsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daugherty.elevatorsystem.model.Challenge;
import com.daugherty.elevatorsystem.service.Dispatcher;

@RestController
public class ElevatorController {

    @Autowired
    private Dispatcher elevatorDispatcher;

    @RequestMapping(value="/solutions", method=RequestMethod.POST)
    public void solve(@RequestBody Challenge challenge) {
        System.out.println(challenge);
        System.out.println(challenge.getCalls());
        System.out.println(challenge.getCalls());

        elevatorDispatcher.solveChallenge(challenge);

        // return new Solution(1, "test");
    }
}
