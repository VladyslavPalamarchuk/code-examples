package com.example.codeexamples.polymorphism.selector.controller;

import com.example.codeexamples.polymorphism.selector.dto.BookExtensionType;
import com.example.codeexamples.polymorphism.selector.model.Book;
import com.example.codeexamples.polymorphism.selector.model.EpubBook;
import com.example.codeexamples.polymorphism.selector.model.Fb2Book;
import com.example.codeexamples.polymorphism.selector.model.PdfBook;
import com.example.codeexamples.polymorphism.selector.service.BookProcessor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/polymorphism/selector/book/convert")
@Api(tags = "Polymorphism book selector API")
@RestController
public class BookController {

    private final BookProcessor bookProcessor;

    @PostMapping("/epub}")
    @ApiOperation(value = "Convert epub book")
    public ResponseEntity<Book> convertToEpub(@RequestBody EpubBook epubBook,
            @RequestParam BookExtensionType convertTo) {
        return ResponseEntity.ok(bookProcessor.processBook(epubBook, convertTo));
    }

    @PostMapping("/pdf")
    @ApiOperation(value = "Convert pdf book")
    public ResponseEntity<Book> convertToPdf(@RequestBody PdfBook pdfBook, @RequestParam BookExtensionType convertTo) {
        return ResponseEntity.ok(bookProcessor.processBook(pdfBook, convertTo));
    }

    @PostMapping("/fb2")
    @ApiOperation(value = "Convert fb2 book")
    public ResponseEntity<Book> convertToFb2(@RequestBody Fb2Book fb2Book, @RequestParam BookExtensionType convertTo) {
        return ResponseEntity.ok(bookProcessor.processBook(fb2Book, convertTo));
    }
}
