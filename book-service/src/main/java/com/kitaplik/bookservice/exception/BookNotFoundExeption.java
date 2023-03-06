package com.kitaplik.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class BookNotFoundExeption extends RuntimeException {
    public BookNotFoundExeption(String s) {
        super(s);
    }
}
