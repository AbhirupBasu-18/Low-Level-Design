package com.abhirup.problems.parkinglot.payment;

public class CashPayment implements PaymentType{
    @Override
    public boolean pay(Integer amount) {
        System.out.println(amount+ " paid by Cash");
        return true;
    }
}
