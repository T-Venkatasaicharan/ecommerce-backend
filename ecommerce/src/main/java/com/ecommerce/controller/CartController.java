package com.ecommerce.controller;

import com.ecommerce.model.Cart;
import com.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    // Add to cart
    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    // Get cart by user
    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId) {
        return cartRepository.findByUserId(userId);
    }
}