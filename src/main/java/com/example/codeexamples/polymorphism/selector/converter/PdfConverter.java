package com.example.codeexamples.polymorphism.selector.converter;

import com.example.codeexamples.polymorphism.selector.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.selector.model.Book;
import com.example.codeexamples.polymorphism.selector.model.PdfBook;
import org.springframework.stereotype.Component;

@Component
public class PdfConverter implements BookConverter<PdfBook, Book>{

    @Override
    public PdfBook convert(Book book) {
        return new PdfBook().setText(book.getText());
    }

    @Override
    public BookExtensionType getConverterType() {
        return BookExtensionType.PDF;
    }
}
