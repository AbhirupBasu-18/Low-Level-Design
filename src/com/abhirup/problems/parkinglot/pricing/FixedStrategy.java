package com.abhirup.problems.parkinglot.pricing;

public class FixedStrategy implements CostComputingStrategy{
    @Override
    public Integer amount(Integer hours) {
        //100 rupee per hour
        return 100* hours;
    }
}
