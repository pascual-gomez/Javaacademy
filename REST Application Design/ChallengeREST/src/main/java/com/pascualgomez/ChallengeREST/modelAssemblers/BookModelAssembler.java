package com.pascualgomez.ChallengeREST.modelAssemblers;

import com.pascualgomez.ChallengeREST.controllers.BookController;
import com.pascualgomez.ChallengeREST.entitites.Book;
import com.pascualgomez.ChallengeREST.entitites.Status;
import com.pascualgomez.ChallengeREST.services.BookService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public
class BookModelAssembler implements RepresentationModelAssembler<Book, EntityModel<Book>> {

    @Override
    public EntityModel<Book> toModel(Book book) {

        // Unconditional links to single-item resource and aggregate root

        EntityModel<Book> bookModel = EntityModel.of(book,
                linkTo(methodOn(BookController.class).one(book.getId())).withSelfRel(),
                linkTo(methodOn(BookController.class).all()).withRel("books"));

        return bookModel;
    }
}
