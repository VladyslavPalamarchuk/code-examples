package com.example.codeexamples.polymorphism.strategy;

import com.example.codeexamples.polymorphism.strategy.converter.BookConverter;
import com.example.codeexamples.polymorphism.strategy.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.strategy.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BookConverterRegister {

    private final Map<BookExtensionType, BookConverter<? extends Book, ? extends Book>> typeToConverter;

    public BookConverterRegister(List<BookConverter<? extends Book, ? extends Book>> converters) {
        typeToConverter = converters.stream().collect(Collectors.toMap(BookConverter::getConverterType, Function.identity()));
    }

    public BookConverter getConverter(BookExtensionType bookExtensionType) {
        return typeToConverter.get(bookExtensionType);
    }
}
