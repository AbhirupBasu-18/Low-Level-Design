package com.abhirup.problems.parkinglot.payment;

public interface PaymentType {
    /**
     * Process payment for the given amount
     * @param amount Amount to be paid
     * @return true if payment is successful, false otherwise
     */
    boolean pay(Integer amount);
}
