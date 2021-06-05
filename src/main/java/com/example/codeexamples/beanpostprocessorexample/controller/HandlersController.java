package com.example.codeexamples.beanpostprocessorexample.controller;

import com.example.codeexamples.beanpostprocessorexample.MainHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/bpp/handle")
@Api(tags = "Handle Bean Post Processor example API")
@RestController
public class HandlersController {

    @Autowired
    private MainHandler mainHandler;

    @PostMapping
    @ApiOperation(value = "Handle event")
    public ResponseEntity<String> handleEvent() {
        mainHandler.handleEvents();
        return ResponseEntity.ok("check the logs!");
    }
}
