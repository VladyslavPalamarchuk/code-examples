package com.example.codeexamples.polymorphism.register.converter;

import com.example.codeexamples.polymorphism.register.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.register.model.Book;
import com.example.codeexamples.polymorphism.register.model.Fb2Book;
import org.springframework.stereotype.Component;

@Component
public class Fb2Converter implements BookConverter<Fb2Book, Book>{

    @Override
    public Fb2Book convert(Book book) {
       return new Fb2Book().setText(book.getText());
    }

    @Override
    public BookExtensionType getConverterType() {
        return BookExtensionType.FB2;
    }
}
