package com.ecommerce.controller;

import com.ecommerce.model.OrderEntity;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }

}