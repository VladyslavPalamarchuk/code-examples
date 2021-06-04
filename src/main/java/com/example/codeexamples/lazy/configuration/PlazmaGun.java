package com.example.codeexamples.lazy.configuration;

import org.springframework.stereotype.Service;

@Service
public class PlazmaGun {

    public PlazmaGun() {
        System.out.println("PlazmaGun was created!");
    }

    public void shoot(Commando commando) {
        System.out.println("Plazma shooting");
        commando.setAlive(false);
    }
}
