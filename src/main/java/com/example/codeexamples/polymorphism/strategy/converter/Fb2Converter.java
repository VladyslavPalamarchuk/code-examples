package com.example.codeexamples.polymorphism.strategy.converter;

import com.example.codeexamples.polymorphism.strategy.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.strategy.model.Book;
import com.example.codeexamples.polymorphism.strategy.model.Fb2Book;
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
