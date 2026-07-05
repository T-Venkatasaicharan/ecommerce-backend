package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderEntity;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrders(@PathVariable Long userId){
        return orderService.getOrdersByUserId(userId);
    }


}