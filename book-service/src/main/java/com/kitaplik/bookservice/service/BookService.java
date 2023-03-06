package com.kitaplik.bookservice.service;

import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.dto.BookIdDto;
import com.kitaplik.bookservice.exception.BookNotFoundExeption;
import com.kitaplik.bookservice.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<BookDto> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(BookDto::convert)
                .collect(Collectors.toList());
    }

    public BookIdDto findByIsbn(String isbn) {
        return bookRepo.getBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundExeption("Book could not found by isbn : " + isbn));
        //BookNotFoundExeption nesne oluşturmanın maliyeti try catch'e göre cok fazladır.
        //try catch x ise BookNotFoundExeption'u new lemek 10 20 x dir.
        //throw etmekde 0,5 kadar

    }

    public BookDto findBookDetailsById(String id) {
        return bookRepo.findById(id)
                .map(BookDto::convert)
                .orElseThrow(() -> new BookNotFoundExeption("Book could not found by id : " + id));
    }
}
