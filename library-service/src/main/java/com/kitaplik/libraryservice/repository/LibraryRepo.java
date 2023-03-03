package com.kitaplik.libraryservice.repository;

import com.kitaplik.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository< Library,String> {
}
