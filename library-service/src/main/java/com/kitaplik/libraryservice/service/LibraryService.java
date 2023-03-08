package com.kitaplik.libraryservice.service;

import com.kitaplik.libraryservice.client.BookServiceClient;
import com.kitaplik.libraryservice.dto.AddBookRequest;
import com.kitaplik.libraryservice.dto.LibraryDto;
import com.kitaplik.libraryservice.exception.LibraryNotFoundException;
import com.kitaplik.libraryservice.model.Library;
import com.kitaplik.libraryservice.repository.LibraryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepo libraryRepo;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepo libraryRepo, BookServiceClient bookServiceClient) {
        this.libraryRepo = libraryRepo;
        this.bookServiceClient = bookServiceClient;
    }

    //-->>getAllBooksInLibraryById id ile bir sorgulama yapılıyor karşışığında kütüphaneye ait bütün kitaplar geri dönüyor
    //null kullanmadım burada LibraryDto da val userBookList:
    // List<BookDto>? null olabilir
    // defaultuda = ArrayList() olsun ddedım
    public LibraryDto getAllBooksInLibraryById(String id) {
        Library library = libraryRepo.findById(id)
                //orElseThrow sebebi jparepositorynin findById metodu optinal döner.bu optionalı controllere geri göndermemeliyiz
                //sebebi ise->optional bir seriazble nesne değildir
                .orElseThrow(() -> new LibraryNotFoundException("ID'ye göre kütüphane bulunamadı: " + id));

        LibraryDto libraryDto = new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())
                        .collect(Collectors.toList()));
        return libraryDto;
    }

    public List<String> getAllLibrary() {
       return libraryRepo.findAll().stream()
                .map(l -> l.getId())
                .collect(Collectors.toList());
    }


    public LibraryDto createLibrary() {
        Library newLibrary = libraryRepo.save(new Library());
        return new LibraryDto(newLibrary.getId());
    }


    public void addBookToLibrary(AddBookRequest bookRequest) {
        String bookId = bookServiceClient.getBookByIsbn(bookRequest.getIsbn()).getBody().getBookId();
        Library library = libraryRepo.findById(bookRequest.getId())
                .orElseThrow(() -> new LibraryNotFoundException
                        ("ID'ye göre kütüphane bulunamadı: " + bookRequest.getId()));
        library.getUserBook().add(bookId);
        libraryRepo.save(library);
    }
}




