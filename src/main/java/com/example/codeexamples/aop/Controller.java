package com.example.codeexamples.aop;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/aop")
@Api(tags = "AOP execution time example API")
@RestController
public class Controller {

    @Autowired
    private Service service;

    @PostMapping
    public ResponseEntity<String> test() {
        service.doWork();
        return ResponseEntity.ok("See the logs!");
    }
}
