package com.example.codeexamples.lazy.configuration;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Commando {

    private boolean alive;

    public Commando() {
        System.out.println(getClass().getSimpleName() + " was created!");
    }
}
