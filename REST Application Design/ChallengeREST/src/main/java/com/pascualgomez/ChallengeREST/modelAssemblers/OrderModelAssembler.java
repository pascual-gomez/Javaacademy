package com.pascualgomez.ChallengeREST.modelAssemblers;

import com.pascualgomez.ChallengeREST.controllers.BookController;
import com.pascualgomez.ChallengeREST.controllers.OrderController;
import com.pascualgomez.ChallengeREST.entitites.Book;
import com.pascualgomez.ChallengeREST.entitites.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public
class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order) {

        // Unconditional links to single-item resource and aggregate root

        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        return orderModel;
    }
}
