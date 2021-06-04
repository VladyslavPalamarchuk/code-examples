package com.example.codeexamples.lazy.configuration;

import org.springframework.stereotype.Component;

@Component
public class AnotherBean3 {

    public AnotherBean3() {
        System.out.println(getClass().getSimpleName() + " was created!");
    }
}
