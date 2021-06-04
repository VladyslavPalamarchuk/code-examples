package com.example.codeexamples.lazy.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/blaster")
@Api(tags = "Lazy Blaster example API")
@RestController
public class TerminatorController {

    @Autowired
    private Terminator terminator;

    @PostMapping
    @ApiOperation(value = "Kill enemies")
    public ResponseEntity<String> killEnemies() {
        terminator.killEnemies();
        return ResponseEntity.ok("check the logs!");
    }
}
