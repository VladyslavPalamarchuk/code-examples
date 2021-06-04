package com.example.codeexamples.polymorphism.selector;

import com.example.codeexamples.polymorphism.selector.converter.BookConverter;
import com.example.codeexamples.polymorphism.selector.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.selector.model.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class BookConverterRegister {

    private final Map<BookExtensionType, BookConverter<? extends Book, ? extends Book>> typeToConverter;

    public BookConverterRegister(List<BookConverter<? extends Book, ? extends Book>> converters) {
        typeToConverter = new HashMap<>();

        for (BookConverter<? extends Book, ? extends Book> bookConverter : converters) {
            typeToConverter.put(bookConverter.getConverterType(), bookConverter);
        }
    }

    public BookConverter getConverter(BookExtensionType bookExtensionType) {
        return typeToConverter.get(bookExtensionType);
    }
}
