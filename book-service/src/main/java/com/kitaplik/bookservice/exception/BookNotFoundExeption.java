package com.kitaplik.bookservice.exception;


public class BookNotFoundExeption extends RuntimeException {
    public BookNotFoundExeption(String s) {
        super(s);
    }
}
