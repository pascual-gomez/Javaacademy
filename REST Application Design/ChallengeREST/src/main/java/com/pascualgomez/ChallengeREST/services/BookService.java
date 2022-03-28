package com.pascualgomez.ChallengeREST.services;

import com.pascualgomez.ChallengeREST.controllers.BookController;
import com.pascualgomez.ChallengeREST.entitites.Book;
import com.pascualgomez.ChallengeREST.entitites.Status;
import com.pascualgomez.ChallengeREST.exceptions.BookNotFoundException;
import com.pascualgomez.ChallengeREST.modelAssemblers.BookModelAssembler;
import com.pascualgomez.ChallengeREST.repositories.BookRepository;
import com.pascualgomez.ChallengeREST.repositories.CategoryRepository;
import com.pascualgomez.ChallengeREST.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    private BookModelAssembler assembler;

    // POST - BOOK
    public ResponseEntity<?> saveBook(Book newBook) {

        categoryRepository.save(newBook.getCategory());
        tagRepository.save(newBook.getTag());

        EntityModel<Book> entityModel = assembler.toModel(bookRepository.save(newBook));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    // GET - ALL BOOKS
    public CollectionModel<EntityModel<Book>> getAllBooks() {

        List<EntityModel<Book>> books = bookRepository.
                findAll().stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).all()).withSelfRel());
    }

    // GET - ONE BOOK
    public EntityModel<Book> findById(Long id) {
        Book book = bookRepository.findById(id) //
                .orElseThrow(() -> new BookNotFoundException(id));

        return assembler.toModel(book);
    }

    // GET - BOOK BY STATUS
    public CollectionModel<EntityModel<Book>> findByStatus(Status status) {
        List<EntityModel<Book>> books = bookRepository.findByStatus(status).
                stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).all()).withSelfRel());
    }

    //PUT - UPDATE A BOOK
    public ResponseEntity<?> editBook(Book newBook, long id) {
        Book updatedBook = bookRepository.findById(id) //
                .map(book -> {
                    book.setCategory(newBook.getCategory());
                    book.setName(newBook.getName());
                    book.setTag(newBook.getTag());
                    book.setStatus(newBook.getStatus());

                    categoryRepository.save(newBook.getCategory());
                    tagRepository.save(newBook.getTag());
                    return bookRepository.save(book);
                }) //
                .orElseGet(() -> {
                    newBook.setId(id);

                    categoryRepository.save(newBook.getCategory());
                    tagRepository.save(newBook.getTag());
                    return bookRepository.save(newBook);
                });

        EntityModel<Book> entityModel = assembler.toModel(updatedBook);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }
}
