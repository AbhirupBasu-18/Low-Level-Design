package com.abhirup.problems.SnakeAndLadder.strategy;

import com.abhirup.problems.SnakeAndLadder.Handler.InputHandler;
import com.abhirup.problems.SnakeAndLadder.model.Cell;
import com.abhirup.problems.SnakeAndLadder.model.Jump;

public class UserInputStrategy implements BoardInitializationStrategy {
    private InputHandler input;

    public UserInputStrategy(InputHandler input) {
        this.input = input;
    }

    @Override
    public void addSnakesAndLadders(Cell[][] grid, int size, int noOfSnakes, int noOfLadders) {
        // Add snakes
        int snakesAdded = 0;
        while (snakesAdded < noOfSnakes) {
            System.out.println("Please enter the position of the snake (head tail):");
            int snakeHead = input.nextInt();
            int snakeTail = input.nextInt();
            
            if (isValidSnakePosition(grid,size,snakeHead, snakeTail)) {
                Jump jump = new Jump(snakeHead, snakeTail);
                Cell c = getCell(grid,size,snakeHead);
                c.setJump(jump);
                System.out.println("Snake added successfully from " + snakeHead + " to " + snakeTail);
                snakesAdded++;
            } else {
                System.out.println("Please enter valid position of the snake");
            }
        }

        // Add ladders
        int laddersAdded = 0;
        while (laddersAdded < noOfLadders) {
            System.out.println("Please enter the position of the ladder (tail top):");
            int ladderTail = input.nextInt();
            int ladderTop = input.nextInt();
            
            if (isValidLadderPosition(grid,size,ladderTail, ladderTop)) {
                Jump jump = new Jump(ladderTail, ladderTop);
                Cell c = getCell(grid,size,ladderTail);
                c.setJump(jump);
                System.out.println("Ladder added successfully from " + ladderTail + " to " + ladderTop);
                laddersAdded++;
            } else {
                System.out.println("Please enter valid position of the ladder");
            }
        }
    }

    private boolean isValidSnakePosition(Cell[][] grid,int size,int snakeHead, int snakeTail) {
        return snakeHead >= snakeTail + size && 
               snakeHead < (size * size - 1) && 
               snakeHead >= 0 && snakeTail >= 0 && 
               snakeHead < (size * size) && 
               snakeTail < (size * size) && 
               snakeTail < (size * (size - 1)) &&
               getCell(grid,size,snakeHead).getJump() == null;
    }

    private boolean isValidLadderPosition(Cell[][] grid,int size,int ladderTail, int ladderTop) {
        return ladderTop >= ladderTail + size && 
               ladderTop >= 0 && ladderTail >= 0 && 
               ladderTail < (size * size) && 
               ladderTop < (size * size) && 
               ladderTail < (size * (size - 1)) &&
               getCell(grid,size,ladderTail).getJump() == null;
    }

    private Cell getCell(Cell[][] grid,int size,int position) {
        int row = position / size;
        int col = position % size;
        return grid[row][col];
    }
}

