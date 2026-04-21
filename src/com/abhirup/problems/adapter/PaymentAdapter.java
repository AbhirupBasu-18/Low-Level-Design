package com.abhirup.problems.adapter;

public class PaymentAdapter implements PaymentGateway {
    private RazorPayApi razorPayApi;

    public PaymentAdapter() {
        this.razorPayApi = new RazorPayApi();
    }

    @Override
    public void pay(String orderId, double amount) {
        razorPayApi.makePayment(orderId, amount);
    }
}
