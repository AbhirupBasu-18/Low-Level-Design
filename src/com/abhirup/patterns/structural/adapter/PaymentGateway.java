package com.abhirup.patterns.structural.adapter;

public interface PaymentGateway {
    void pay(String orderId, double amount);
}
