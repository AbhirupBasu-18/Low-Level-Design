package com.abhirup.problems.parkinglot.payment;

public class UpiPayment implements PaymentType{
    @Override
    public boolean pay(Integer amount) {
        System.out.println(amount+ " paid by UPI");
        return true;
    }
}
