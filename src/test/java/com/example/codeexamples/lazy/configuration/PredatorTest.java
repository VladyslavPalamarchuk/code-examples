package com.example.codeexamples.lazy.configuration;

import static org.junit.Assert.assertFalse;

import com.example.codeexamples.lazy.configuration.PredatorTest.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class PredatorTest {

    @Autowired
    private Commando commando;

    @Autowired
    private Predator predator;

    @Test
    public void predatorKillCommando() {
        predator.fight(commando);
        assertFalse(commando.isAlive());
    }

    @Configuration
    // set false to see that all beans will be created in configuration package. initLazy=true - will create only bean definitions
    @ComponentScan(lazyInit = true)
    static class TestConfig {

    }
}