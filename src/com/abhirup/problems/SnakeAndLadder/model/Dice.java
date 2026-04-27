package com.abhirup.problems.SnakeAndLadder.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int diceCount;
    public Dice(int diceCount){
        this.diceCount=diceCount;
    }
    public int rollDice(){
        int ans = 0 ;
        for(int i=0;i<diceCount;i++){
            ans+=ThreadLocalRandom.current().nextInt(1,7);
        }
        return ans;
    }
}
