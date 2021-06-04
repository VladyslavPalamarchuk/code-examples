package com.example.codeexamples.lazy.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Predator {

    @Autowired
    private PlazmaGun lazer;

    public Predator() {
        System.out.println("Predator was created!");
    }

    public void fight(Commando commando) {
        lazer.shoot(commando);
    }
}
