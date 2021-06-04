package com.example.codeexamples.lazy.configuration;

import org.springframework.stereotype.Component;

@Component
public class AnotherBean2 {

    public AnotherBean2() {
        System.out.println(getClass().getSimpleName() + " was created!");
    }
}
