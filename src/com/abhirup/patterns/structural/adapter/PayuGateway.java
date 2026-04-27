package com.abhirup.patterns.structural.adapter;

public class PayuGateway implements PaymentGateway {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Processing payment through PayuGateway for Order ID: " + orderId + " with amount: " + amount);
        // Simulate payment processing logic here
    }
}
