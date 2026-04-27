package com.abhirup.patterns.structural.adapter;

public class RazorPayApi {
    public void makePayment(String orderId, double amount) {
        System.out.println("Processing payment through RazorPay for Order ID: " + orderId + " with amount: " + amount);
    }
}
