package com.example.codeexamples.polymorphism.strategy.model;

import com.example.codeexamples.polymorphism.strategy.dto.BookExtensionType;

public interface Book {

    String getText();
    BookExtensionType getBookExtensionType();
}
