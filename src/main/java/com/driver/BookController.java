package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity findBookById(@RequestBody String id){
        Book response=bookService.findBookById(id);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-books")
    public ResponseEntity findAllBooks(){
        List<Book> response = bookService.findAllBooks();
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("/get-books-by-author")
    public ResponseEntity findBooksByAuthor(@RequestParam("author") String author){
        List<Book> response = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("/get-books-by-genre")
    public ResponseEntity findBooksByGenre(@RequestParam("genre") String genre){
        List<Book>response=bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@RequestParam("id") String id){
         bookService.deleteBookById(id);
         return new ResponseEntity<>("deleted",HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
    }
}
