package com.example.codeexamples.propertiesconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {

    @Bean
    @ConfigurationProperties("spring.elasticsearch.rest")
    public ElasticSearchProperties elasticSearchProperties() {
        return new ElasticSearchProperties();
    }
}
