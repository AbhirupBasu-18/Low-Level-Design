package com.abhirup.problems.tictactoe.model;

public class Board {
    private int size;
    private Piece[][] grid;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getGrid() {
        return grid;
    }

    public void setGrid(Piece[][] grid) {
        this.grid = grid;
    }

    public Board(int size) {
        this.size = size;
        this.grid = new Piece[size][size];
    }
    public boolean addPiece(int row, int col, Piece piece) {
        if (row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == null) {
            grid[row][col] = piece;
            return true;
        }
        else{
            return false;
        }
    }
    //print the board
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    System.out.print("-");
                } else {
                    System.out.print(grid[i][j].getType().name());
                }
            }
            System.out.print("\n");
        }
    }
    //check if the board is full
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }
    //
}
