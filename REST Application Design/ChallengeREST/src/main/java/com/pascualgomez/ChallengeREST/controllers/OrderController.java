package com.pascualgomez.ChallengeREST.controllers;

import com.pascualgomez.ChallengeREST.entitites.Book;
import com.pascualgomez.ChallengeREST.entitites.Order;
import com.pascualgomez.ChallengeREST.entitites.Status;
import com.pascualgomez.ChallengeREST.services.OrderService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<?> newOrder(@RequestBody Order newOrder) {

        ResponseEntity<?> response = orderService.saveOrder(newOrder);

        return response;
    }

    @GetMapping("/order/{id}")
    public EntityModel<Order> one(@PathVariable Long id) {

        EntityModel<Order> order = orderService.findById(id);

        return order;
    }

    @PutMapping("/order/{id}")
    ResponseEntity<?> replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {

        ResponseEntity<?> response = orderService.editOrder(newOrder, id);

        return response;
    }

    @GetMapping("/order")
    public CollectionModel<EntityModel<Order>> all() {

        CollectionModel<EntityModel<Order>> orders = orderService.getAllOrders();

        return orders;
    }
}
