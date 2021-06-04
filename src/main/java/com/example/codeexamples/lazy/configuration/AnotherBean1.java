package com.example.codeexamples.lazy.configuration;

import org.springframework.stereotype.Component;

@Component
public class AnotherBean1 {

    public AnotherBean1() {
        System.out.println(getClass().getSimpleName() + " was created!");
    }
}
