package com.abhirup.problems.adapter;

public interface PaymentGateway {
    void pay(String orderId, double amount);
}
