package com.example.codeexamples.polymorphism.strategy.converter;

import com.example.codeexamples.polymorphism.strategy.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.strategy.model.Book;

public interface BookConverter<T extends Book, E extends Book> {

    T convert(E book);

    BookExtensionType getConverterType();
}
