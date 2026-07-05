package com.ecommerce.service;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Order placeOrder(Order order){
        order.setStatus("placed");
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }
    public List<Order> getOrdersByUserId(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
        return orderRepository.findByUser(user);
    }
    public List<Order> getOrdersByUser(User user){
        return orderRepository.findByUser(user);
    }
}
