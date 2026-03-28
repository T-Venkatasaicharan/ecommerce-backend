package com.ecommerce.controller;

import com.ecommerce.model.OrderEntity;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        order.setStatus("COD");
        return orderRepository.save(order);
    }
}