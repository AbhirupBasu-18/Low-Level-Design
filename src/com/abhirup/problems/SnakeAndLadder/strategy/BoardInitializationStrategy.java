package com.abhirup.problems.SnakeAndLadder.strategy;

import com.abhirup.problems.SnakeAndLadder.model.Cell;

public interface BoardInitializationStrategy {
    void addSnakesAndLadders(Cell[][] grid, int size, int noOfSnakes, int noOfLadders);
}
