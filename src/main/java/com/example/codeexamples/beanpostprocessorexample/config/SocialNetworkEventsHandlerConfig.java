package com.example.codeexamples.beanpostprocessorexample.config;

import com.example.codeexamples.beanpostprocessorexample.InjectListBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocialNetworkEventsHandlerConfig {

    @Bean
    public InjectListBeanPostProcessor injectListBeanPostProcessor() {
        return new InjectListBeanPostProcessor();
    }
}
