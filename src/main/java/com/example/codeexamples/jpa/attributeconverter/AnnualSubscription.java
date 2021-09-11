package com.example.codeexamples.jpa.attributeconverter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.MonthDay;

@Entity
@Table(name = "annual_subscription")
@Getter
@Setter
@Accessors(chain = true)
public class AnnualSubscription {

    @Id
    private Long id;

    @Column(name = "payment_day", columnDefinition = "date")
    @Convert(converter = MonthDayDateAttributeConverter.class)
    private MonthDay paymentDay;
}


