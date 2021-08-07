package com.example.codeexamples.propertiesconfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/configuration/properties")
@RestController
public class PropertiesController {

    @Autowired
    private ElasticSearchProperties elasticSearchProperties;

    @GetMapping
    public ResponseEntity<ElasticSearchProperties> getElasticProperties() {
        return ResponseEntity.ok(elasticSearchProperties);
    }
}
