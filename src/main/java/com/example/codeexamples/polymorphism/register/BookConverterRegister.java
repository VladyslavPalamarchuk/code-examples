package com.example.codeexamples.polymorphism.register;

import com.example.codeexamples.polymorphism.register.converter.BookConverter;
import com.example.codeexamples.polymorphism.register.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.register.model.Book;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

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
