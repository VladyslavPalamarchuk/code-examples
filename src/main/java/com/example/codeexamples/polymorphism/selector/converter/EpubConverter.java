package com.example.codeexamples.polymorphism.selector.converter;

import com.example.codeexamples.polymorphism.selector.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.selector.model.Book;
import com.example.codeexamples.polymorphism.selector.model.EpubBook;
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
