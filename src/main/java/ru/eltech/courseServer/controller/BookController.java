package ru.eltech.courseServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eltech.courseServer.entity.BookEntity;
import ru.eltech.courseServer.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity getBooks() {
        try {
            List<BookEntity> books = bookService.getBooks();
            return ResponseEntity.ok(books);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createBook(@RequestParam String title, @RequestParam String author, @RequestParam int price) {
        try {
            BookEntity book = bookService.createBook(title, author, price);
            return ResponseEntity.ok(book);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable int id, @RequestParam String title, @RequestParam String author, @RequestParam int price) {
        try {
            bookService.updateBook(id, title, author, price);
            BookEntity updatedBook = new BookEntity(id, title, author, price);
            return ResponseEntity.ok(updatedBook);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable int id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok("success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
