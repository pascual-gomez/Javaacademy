package com.pascualgomez.Payroll;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<Order, Long> {
}