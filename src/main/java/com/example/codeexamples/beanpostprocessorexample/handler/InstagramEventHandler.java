package com.example.codeexamples.beanpostprocessorexample.handler;

import org.springframework.stereotype.Component;

@Component
public class InstagramEventHandler implements EventHandler {

    @Override
    public void handle() {
        System.out.println("I'm handling Instagram events..");
    }
}
