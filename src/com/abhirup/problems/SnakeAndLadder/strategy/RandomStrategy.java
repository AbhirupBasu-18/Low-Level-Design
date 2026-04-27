package com.abhirup.problems.SnakeAndLadder.strategy;

import com.abhirup.problems.SnakeAndLadder.model.Cell;
import com.abhirup.problems.SnakeAndLadder.model.Jump;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStrategy implements BoardInitializationStrategy {

    public RandomStrategy() {
    }

    @Override
    public void addSnakesAndLadders(Cell[][] grid, int size, int noOfSnakes, int noOfLadders) {
        // Add random snakes
        int snakesAdded = 0;
        while (snakesAdded < noOfSnakes) {
            int snakeHead = ThreadLocalRandom.current().nextInt(size * size / 2 + 1, size * size - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, snakeHead - size);
            
            if (isValidSnakePosition(grid,size,snakeHead, snakeTail)) {
                Jump jump = new Jump(snakeHead, snakeTail);
                Cell c = getCell(grid,size,snakeHead);
                c.setJump(jump);
                System.out.println("Snake added from " + snakeHead + " to " + snakeTail);
                snakesAdded++;
            }
        }

        // Add random ladders
        int laddersAdded = 0;
        while (laddersAdded < noOfLadders) {
            int ladderTail = ThreadLocalRandom.current().nextInt(0, size * size / 2);
            int ladderTop = ThreadLocalRandom.current().nextInt(ladderTail + size, size * size - 1);
            
            if (isValidLadderPosition(grid,size,ladderTail, ladderTop)) {
                Jump jump = new Jump(ladderTail, ladderTop);
                Cell c = getCell(grid,size,ladderTail);
                c.setJump(jump);
                System.out.println("Ladder added from " + ladderTail + " to " + ladderTop);
                laddersAdded++;
            }
        }
    }

    private boolean isValidSnakePosition(Cell[][] grid, int size,int snakeHead, int snakeTail) {
        return snakeHead >= snakeTail + size && 
               snakeHead < (size * size - 1) && 
               snakeHead >= 0 && snakeTail >= 0 && 
               snakeHead < (size * size) && 
               snakeTail < (size * size) && 
               snakeTail < (size * (size - 1)) &&
               getCell(grid,size,snakeHead).getJump() == null;
    }

    private boolean isValidLadderPosition(Cell[][] grid, int size,int ladderTail, int ladderTop) {
        return ladderTop >= ladderTail + size && 
               ladderTop >= 0 && ladderTail >= 0 && 
               ladderTail < (size * size) && 
               ladderTop < (size * size) && 
               ladderTail < (size * (size - 1)) &&
               getCell(grid,size,ladderTail).getJump() == null;
    }

    private Cell getCell(Cell[][] grid, int size,int position) {
        int row = position / size;
        int col = position % size;
        return grid[row][col];
    }
}

