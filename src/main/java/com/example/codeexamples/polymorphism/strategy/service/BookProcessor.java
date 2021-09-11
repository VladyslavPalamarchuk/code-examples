package com.example.codeexamples.polymorphism.strategy.service;

import com.example.codeexamples.polymorphism.strategy.BookConverterRegister;
import com.example.codeexamples.polymorphism.strategy.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.strategy.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookProcessor {

    private final BookConverterRegister converterSelector;

    public Book processBook(Book book, BookExtensionType convertTo) {
        return converterSelector.getConverter(convertTo).convert(book);
    }
}

