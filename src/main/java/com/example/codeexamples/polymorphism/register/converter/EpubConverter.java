package com.example.codeexamples.polymorphism.register.converter;

import com.example.codeexamples.polymorphism.register.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.register.model.Book;
import com.example.codeexamples.polymorphism.register.model.EpubBook;
import org.springframework.stereotype.Component;

@Component
public class EpubConverter implements BookConverter<EpubBook, Book>{

    @Override
    public EpubBook convert(Book book) {
        return new EpubBook().setText(book.getText());
    }

    @Override
    public BookExtensionType getConverterType() {
        return BookExtensionType.EPUB;
    }
}
