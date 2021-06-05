package com.example.codeexamples.beanpostprocessorexample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectList {
    Class[] value();
}
