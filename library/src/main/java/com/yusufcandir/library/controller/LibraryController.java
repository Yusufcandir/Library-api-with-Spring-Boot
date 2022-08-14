package com.yusufcandir.library.controller;

import com.yusufcandir.library.dto.BookRequest;
import com.yusufcandir.library.model.Book;
import com.yusufcandir.library.model.Reader;
import com.yusufcandir.library.service.BookService;
import com.yusufcandir.library.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class LibraryController {
    private final BookService bookService;
    private final ReaderService readerService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
      return ResponseEntity.ok(bookService.getAllBooks());
    }


    @GetMapping("/readers")
    public ResponseEntity<List<Reader>> getAllReaders(){
        return ResponseEntity.ok(readerService.getAllReaders());
    }



    @GetMapping("/books/{id}")
    public Optional<Book> findByID(@PathVariable Integer id) {

        return bookService.findById(id);


    }

    @PostMapping
    public ResponseEntity<Reader>  requestQueue(@RequestBody BookRequest bookRequest){
        return  ResponseEntity.ok(readerService.requestOrder(bookRequest.getBookIdList(),
                bookRequest.getReaderName()));

    }


    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable Integer id, Book book){
        bookService.updateBook(book,id);
    }

   @DeleteMapping("/books/{id}")
    public  void  deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
   }

   @PutMapping
    public void reduceStock(Book book,Integer amount){
        bookService.reduceStock(book,amount);
   }
}
