package com.kitaplik.bookservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

//@RestControllerAdvice exceptionuı uygulamanın neresınde patlatırsak patlatalım  springin de birkez patlar.
//@ExceptionHandler ise exception (service ya da validation da patlayınca) patladıgı anda controllere gitmeden
//biz yakalayamazsak bile spring kendisi yakalar ve stacke döner. kendimiz hatayı devir alıp handler ederi  durumu extra malıyetten de kurtatıt
@RestControllerAdvice
public class GeneralExceptionHandler  {



    @ExceptionHandler(BookNotFoundExeption.class)
    public ResponseEntity<?>handle (BookNotFoundExeption bookNotFoundExeption){
        return new ResponseEntity<>(bookNotFoundExeption.getMessage(), HttpStatus.NOT_FOUND);

    }
}
