package com.abhirup.problems.SnakeAndLadder.model;

import com.abhirup.problems.SnakeAndLadder.strategy.BoardInitializationStrategy;


public class Board {
    private int size;
    private Cell[][] grid;

    public Board(int size, int noOfSnakes, int noOfLadder, BoardInitializationStrategy strategy) {
        initialize(size);
        strategy.addSnakesAndLadders(grid, size, noOfSnakes, noOfLadder);
    }
    private void initialize(int size){
        this.grid = new Cell[size][size];
        this.size = size;
        for(int i =0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j]= new Cell();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int position) {
        int row = position / size;
        int col = position % size;
        return grid[row][col];
    }

}
