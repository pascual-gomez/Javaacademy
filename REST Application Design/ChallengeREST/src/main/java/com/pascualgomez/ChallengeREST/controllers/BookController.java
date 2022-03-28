package com.pascualgomez.ChallengeREST.controllers;

import com.pascualgomez.ChallengeREST.entitites.Book;
import com.pascualgomez.ChallengeREST.entitites.Status;
import com.pascualgomez.ChallengeREST.services.BookService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<?> newBook(@RequestBody Book newBook) {

        ResponseEntity<?> response = bookService.saveBook(newBook);

        return response;
    }

    @GetMapping("/book/{id}")
    public EntityModel<Book> one(@PathVariable Long id) {

        EntityModel<Book> book = bookService.findById(id);

        return book;
    }

    @PutMapping("/book/{id}")
    ResponseEntity<?> replaceBook(@RequestBody Book newBook, @PathVariable Long id) {

        ResponseEntity<?> response = bookService.editBook(newBook, id);

        return response;
    }

    @GetMapping("/book/{status}")
    public CollectionModel<EntityModel<Book>> allByStatus(@PathVariable Status status) {

        CollectionModel<EntityModel<Book>> books = bookService.findByStatus(status);

        return books;
    }

    @GetMapping("/book")
    public CollectionModel<EntityModel<Book>> all() {

        CollectionModel<EntityModel<Book>> books = bookService.getAllBooks();

        return books;
    }



}
