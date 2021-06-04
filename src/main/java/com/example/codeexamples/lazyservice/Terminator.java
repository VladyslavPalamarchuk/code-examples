package com.example.codeexamples.lazyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Terminator {

    @Autowired
    @Lazy
    private Blaster blaster; // proxy

    private int stamina = 3;

    public void killEnemies() {

        if (!veryTired()) {
            kickWithLog();
        } else {
            blaster.fire();
        }
        stamina--;
    }

    private boolean veryTired() {
        return stamina < 0;
    }

    private void kickWithLog() {
        System.out.println("I'll kill you with my log!");
    }
}
