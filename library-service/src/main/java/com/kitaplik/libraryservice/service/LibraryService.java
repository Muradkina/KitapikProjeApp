package com.kitaplik.libraryservice.service;

import com.kitaplik.libraryservice.dto.LibraryDto;
import com.kitaplik.libraryservice.exception.LibraryNotFoundException;
import com.kitaplik.libraryservice.model.Library;
import com.kitaplik.libraryservice.repository.LibraryRepo;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private final LibraryRepo libraryRepo;

    public LibraryService(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }
    //-->>getAllBooksInLibraryById id ile bir sorgulama yapılıyor karşışığında kütüphaneye ait bütün kitaplar geri dönüyor
    public LibraryDto getAllBooksInLibraryById (String id){
        Library library=libraryRepo.findById(id)
                //orElseThrow sebebi jparepositorynin findById metodu optinal döner.bu optionalı controllere geri göndermemeliyizz
                //sebebi ise->optional bir seriazble nesne değildir
                .orElseThrow(()->new LibraryNotFoundException("Library could not found by id: "+id));

        //null kullanmadım burada LibraryDto da val userBookList: List<BookDto>? null olabilir
        // defaultuda = ArrayList() olsun ddedım
        LibraryDto libraryDto=new LibraryDto(library.getId());//null);

        return libraryDto;

    }
    public LibraryDto createLibrary(){
        Library newLibrary=libraryRepo.save(new Library());
        return new LibraryDto(newLibrary.getId());
    }
}
