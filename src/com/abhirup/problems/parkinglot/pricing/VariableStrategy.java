package com.abhirup.problems.parkinglot.pricing;

public class VariableStrategy implements CostComputingStrategy{
    @Override
    public Integer amount(Integer hours) {
        //100 rupee initial
        //decreases 10 rupee after each hour
        return (hours*(2*100+(hours-1)*(-10)))/2;
    }
}
