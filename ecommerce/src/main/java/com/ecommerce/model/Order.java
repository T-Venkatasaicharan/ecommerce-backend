package com.ecommerce.model;

import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private double total;

    public int getId() { return id; }
    public String getAddress() { return address; }
    public double getTotal() { return total; }

    public void setAddress(String address) { this.address = address; }
    public void setTotal(double total) { this.total = total; }
}