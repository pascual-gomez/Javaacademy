package com.pascualgomez.ChallengeREST.services;

import com.pascualgomez.ChallengeREST.controllers.BookController;
import com.pascualgomez.ChallengeREST.controllers.OrderController;
import com.pascualgomez.ChallengeREST.entitites.Book;
import com.pascualgomez.ChallengeREST.entitites.Order;
import com.pascualgomez.ChallengeREST.exceptions.BookNotFoundException;
import com.pascualgomez.ChallengeREST.exceptions.OrderNotFoundException;
import com.pascualgomez.ChallengeREST.modelAssemblers.OrderModelAssembler;
import com.pascualgomez.ChallengeREST.repositories.OrderRepository;
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
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private OrderModelAssembler assembler;

    // POST - ORDER
    public ResponseEntity<?> saveOrder(Order newOrder) {

        EntityModel<Order> entityModel = assembler.toModel(orderRepository.save(newOrder));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    // GET - ALL ORDERS
    public CollectionModel<EntityModel<Order>> getAllOrders() {

        List<EntityModel<Order>> orders = orderRepository.
                findAll().stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(orders,
                linkTo(methodOn(OrderController.class).all()).withSelfRel());
    }

    // GET - ONE ORDER
    public EntityModel<Order> findById(Long id) {
        Order order = orderRepository.findById(id) //
                .orElseThrow(() -> new OrderNotFoundException(id));

        return assembler.toModel(order);
    }

    //PUT - UPDATE A ORDER
    public ResponseEntity<?> editOrder(Order newOrder, long id) {
        Order updatedOrder = orderRepository.findById(id) //
                .map(order -> {
                    order.setBookId(newOrder.getBookId());
                    order.setQuantity(newOrder.getQuantity());
                    order.setShipDate(newOrder.getShipDate());
                    order.setStatus(newOrder.getStatus());
                    order.setComplete(newOrder.isComplete());

                    return orderRepository.save(order);
                }) //
                .orElseGet(() -> {
                    newOrder.setId(id);

                    return orderRepository.save(newOrder);
                });

        EntityModel<Order> entityModel = assembler.toModel(updatedOrder);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }
}
