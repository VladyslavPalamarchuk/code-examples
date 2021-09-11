package com.example.codeexamples.polymorphism.strategy.model;

import com.example.codeexamples.polymorphism.strategy.dto.BookExtensionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PdfBook implements Book{

    String text;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public BookExtensionType getBookExtensionType() {
        return BookExtensionType.PDF;
    }
}
