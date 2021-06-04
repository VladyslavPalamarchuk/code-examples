package com.example.codeexamples.lazy.service;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class Blaster {

    @PostConstruct
    public void init() {
        System.out.println("you pay 100500$ for blaster");
    }

    public void fire() {
        System.out.println("BOOM BOOM BOOM...");
    }
}
