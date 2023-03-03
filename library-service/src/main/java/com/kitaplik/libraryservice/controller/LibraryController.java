package com.kitaplik.libraryservice.controller;

import com.kitaplik.libraryservice.dto.LibraryDto;
import com.kitaplik.libraryservice.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
@Validated
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService  libraryService){
        this.libraryService=libraryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto>getLibraryById( @PathVariable  String id){
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto>createLibrary(){
         return ResponseEntity.ok(libraryService.createLibrary());
    }
}
