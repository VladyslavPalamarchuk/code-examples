package com.example.codeexamples.polymorphism.selector.model;

import com.example.codeexamples.polymorphism.selector.dto.BookExtensionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class EpubBook implements Book {

    String text;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public BookExtensionType getBookExtensionType() {
        return BookExtensionType.EPUB;
    }
}
