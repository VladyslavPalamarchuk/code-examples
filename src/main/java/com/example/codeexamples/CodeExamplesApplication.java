package com.example.codeexamples;

import com.example.codeexamples.propertiesconfig.ElasticSearchProperties;
import com.example.codeexamples.propertiesconfig.PropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PropertiesConfig.class)
public class CodeExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeExamplesApplication.class, args);
    }

}
