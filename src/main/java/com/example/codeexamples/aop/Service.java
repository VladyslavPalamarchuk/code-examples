package com.example.codeexamples.aop;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class Service {

    @SneakyThrows
    @LogExecutionTime
    public void doWork() {
        Thread.sleep(2000);
    }
}
