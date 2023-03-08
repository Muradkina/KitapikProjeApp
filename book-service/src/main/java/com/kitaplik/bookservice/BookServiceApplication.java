package com.kitaplik.bookservice;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class BookServiceApplication implements CommandLineRunner {

    private final BookRepo bookRepo;

    public BookServiceApplication(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Book book = new Book("Açlık", 1980, "Knut Hamsun", "Varlık yayınları",
                "777", "Pskoloji");
        Book book1 = new Book("Bilinçaltı ", 1915, "Sigmund Freud", "Yason yayınları",
                "5812", "Pskoloji");
        Book book2 = new Book("Harry Potter ve Felsefe Taşı", 1997, "J. K. Rowling", "YKB Yayınları", "987654", "Fantastik-Bilim Kurgu");
        Book book3 = new Book("\"Yüzüklerin Efendisi", 1960, "J.R.R Tolkien", "Metis Yayıncılık", "456789", "Yüksek Fantazi");

        List<Book> bookList = bookRepo.saveAll(Arrays.asList(book, book1, book2, book3));
        System.out.println(bookList);
        /*String bookListStrin = String.join(", ", bookList.toString());
        System.out.println(bookListStrin);*/
    }
}