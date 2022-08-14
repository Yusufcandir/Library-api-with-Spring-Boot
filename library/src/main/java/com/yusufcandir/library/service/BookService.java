package com.yusufcandir.library.service;


import com.yusufcandir.library.model.Book;

import com.yusufcandir.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

//Todo: will be added genre method
//decided to make it an enum class.

@Service
@AllArgsConstructor
public class BookService {



    private final BookRepository bookRepository;

    public List<Book>getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Integer bookId){


        return Optional.ofNullable(bookRepository.findById(bookId).
                orElseThrow(
                        () -> new IllegalArgumentException("Book with id" + bookId + "could not found")));
    }


    public void updateBook(Book book, Integer bookId) {
      boolean exits=  bookRepository.existsById(bookId);
      if (exits){
          bookRepository.save(book);
      }

    }

    public void deleteBook(Integer bookId) {
         Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Book not found with ID %d", bookId)));

        bookRepository.deleteById(book.getId());
    }

    public void reduceStock(Book book, Integer amount) {

        int i = book.getStock() - amount;
        book.setStock(i);


        bookRepository.save(book);


    }


    }








