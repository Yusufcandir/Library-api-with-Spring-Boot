package com.yusufcandir.library;

import com.yusufcandir.library.enumeration.Genre;
import com.yusufcandir.library.model.Book;
import com.yusufcandir.library.model.Reader;
import com.yusufcandir.library.repository.BookRepository;
import com.yusufcandir.library.repository.ReaderRepository;
import com.yusufcandir.library.service.BookService;
import com.yusufcandir.library.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor

//It is going to be hardcoded for now.
public class LibraryApplication implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final BookService bookService;
    private final ReaderService readerService;
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Book book1= Book.builder().name("Clockwork Orange").author("Anthony Burgess ").stock(25).genre(Genre.Dystopian).build();
        bookService.reduceStock(book1,1);


        Book book2= Book.builder().name("Blindness").author("José Saramago").stock(30).genre(Genre.PostApocalyptic).build();
        bookService.reduceStock(book2,1);


        Book book3= Book.builder().name("A Brief History of Time").author("Stephen Hawking ").stock(13).genre(Genre.Cosmology).build();
        bookService.reduceStock(book3,2);





        Reader reader1=Reader.builder().readerName("Yusuf").book(List.of(book1,book2)).isDeliveryDateExpired(false).build();
        readerService.expiredDate(reader1);


        Reader reader2=Reader.builder().readerName("Elif").book(List.of(book2)).isDeliveryDateExpired(true).build();
        readerService.expiredDate(reader2);

        Reader reader3=Reader.builder().readerName("Zeynep").book(List.of(book3)).isDeliveryDateExpired(false).build();
        readerService.expiredDate(reader3);



        bookRepository.saveAll(Arrays.asList(book1,book2,book3));
        readerRepository.saveAll(Arrays.asList(reader1,reader2,reader3));

    }
}
