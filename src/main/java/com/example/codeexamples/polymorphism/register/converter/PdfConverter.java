package com.example.codeexamples.polymorphism.register.converter;

import com.example.codeexamples.polymorphism.register.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.register.model.Book;
import com.example.codeexamples.polymorphism.register.model.PdfBook;
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
