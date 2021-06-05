package com.example.codeexamples.beanpostprocessorexample.handler;

import org.springframework.stereotype.Component;

@Component
public class TelegramEventHandler implements EventHandler {

    @Override
    public void handle() {
        System.out.println("I'm handling Telegram events...");
    }
}
