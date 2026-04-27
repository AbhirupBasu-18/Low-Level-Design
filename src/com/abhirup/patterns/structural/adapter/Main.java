package com.abhirup.patterns.structural.adapter;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the PayuGateway
        PayuGateway payuGateway = new PayuGateway();

        // Create an adapter for the PayuGateway
        PaymentGateway paymentGatewayAdapter = new PaymentAdapter();

        // Create a checkout service with the adapter
        CheckoutService checkoutService = new CheckoutService(paymentGatewayAdapter);

        // Perform a checkout
        checkoutService.checkout("ORDER123", 99.99);
    }
}
