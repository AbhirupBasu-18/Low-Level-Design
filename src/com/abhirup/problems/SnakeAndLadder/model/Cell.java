package com.abhirup.problems.SnakeAndLadder.model;

public class Cell {
    private Jump jump;

    public boolean isJumpPresent(){
        return jump!=null;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
