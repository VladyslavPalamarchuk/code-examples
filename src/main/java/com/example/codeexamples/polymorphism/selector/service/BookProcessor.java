package com.example.codeexamples.polymorphism.selector.service;

import com.example.codeexamples.polymorphism.selector.BookConverterSelector;
import com.example.codeexamples.polymorphism.selector.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.selector.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookProcessor {

    private final BookConverterSelector converterSelector;

    public Book processBook(Book book, BookExtensionType convertTo) {
        return converterSelector.getConverter(convertTo).convert(book);
    }
}

