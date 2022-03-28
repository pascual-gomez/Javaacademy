package com.pascualgomez.ChallengeREST.repositories;


import com.pascualgomez.ChallengeREST.entitites.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}