package com.example.codeexamples.jpa.attributeconverter;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.MonthDay;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/jpa/attributeconverter")
@Api(tags = "JPA Attribute Converter example API")
@RestController
public class AnnualSubscriptionController {

    private final AnnualSubscriptionRepository annualSubscriptionRepository;

    @PostMapping
    public void save() {
        annualSubscriptionRepository.save(
                new AnnualSubscription()
                        .setId(1L)
                        .setPaymentDay(MonthDay.now())
        );
    }

    @GetMapping
    public ResponseEntity<AnnualSubscription> get() {
        return ResponseEntity.ok(annualSubscriptionRepository.findById(1L).get());
    }
    
}
