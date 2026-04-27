package com.abhirup.problems.SnakeAndLadder.model;

import java.util.Queue;

public class SnakeAndLadderGame {
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    //printing service to be separated in board
    public SnakeAndLadderGame(Board board, Queue<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }
    public void startPlay(){
        int n= board.getSize();
        //we have queue of players
        //we take one turn
        while (!players.isEmpty()){
            Player currentPlayer = players.element();
            players.remove();
            players.add(currentPlayer);
            System.out.println("Player "+currentPlayer.getName()+" is rolling the dice"+" at position "+currentPlayer.getPosition());
            int result = dice.rollDice();
            System.out.println("Dice output :" + result);
            int nextPosition = currentPlayer.getPosition()+result;
            System.out.println("Next Position :" + nextPosition);
            if(nextPosition>=n*n){
                System.out.println("Cannot move, try again in next turn");
                continue;
            }
            int finalPosition = jumpCheck(nextPosition,board);
            System.out.println("New Position of the player is "+finalPosition);
            currentPlayer.setPosition(finalPosition);
            if(finalPosition== n*n-1){
                System.out.println("Winner is :"+currentPlayer.getName());
                break;
            }

        }
    }
    private int jumpCheck(int position, Board board){
        Cell cell = board.getCell(position);
        if(cell.isJumpPresent()){
            Jump jump = cell.getJump();
            String jumpBy = jump.getStart()>jump.getEnd()?"Snake":"Ladder";
            System.out.println("Jump done by "+jumpBy+" to "+jump.getEnd());
            return jump.getEnd();
        }
        return position;
    }
}
