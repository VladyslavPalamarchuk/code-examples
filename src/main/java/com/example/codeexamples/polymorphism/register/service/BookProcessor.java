package com.example.codeexamples.polymorphism.register.service;

import com.example.codeexamples.polymorphism.register.BookConverterRegister;
import com.example.codeexamples.polymorphism.register.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.register.model.Book;
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

