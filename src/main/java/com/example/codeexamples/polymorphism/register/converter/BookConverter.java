package com.example.codeexamples.polymorphism.register.converter;

import com.example.codeexamples.polymorphism.register.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.register.model.Book;

public interface BookConverter<T extends Book, E extends Book> {

    T convert(E book);

    BookExtensionType getConverterType();
}
