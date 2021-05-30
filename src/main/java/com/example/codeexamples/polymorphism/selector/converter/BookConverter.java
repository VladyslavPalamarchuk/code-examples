package com.example.codeexamples.polymorphism.selector.converter;

import com.example.codeexamples.polymorphism.selector.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.selector.model.Book;

public interface BookConverter<T extends Book, E extends Book> {

    T convert(E book);

    BookExtensionType getConverterType();
}
