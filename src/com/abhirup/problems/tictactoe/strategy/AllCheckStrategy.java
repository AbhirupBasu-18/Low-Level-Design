package com.abhirup.problems.tictactoe.strategy;

import com.abhirup.problems.tictactoe.model.Board;

public class AllCheckStrategy implements WinningStrategy {


    @Override
    public boolean checkWin(int row, int col, Board board) {
        //check row
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagMatch = true;
        boolean antiDiagMatch = true;
        for (int j = 0; j < board.getSize(); j++) {
            if (board.getGrid()[row][j] == null || board.getGrid()[row][j].getType() != board.getGrid()[row][col].getType()) {
                rowMatch = false;
                break;
            }
        }
        //check diagonal
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getGrid()[i][i] == null || board.getGrid()[i][i].getType() != board.getGrid()[row][col].getType()) {
                diagMatch = false;
                break;
            }
        }
        //check anti diagonal
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getGrid()[i][board.getSize() - 1 - i] == null || board.getGrid()[i][board.getSize() - 1 - i].getType() != board.getGrid()[row][col].getType()) {
                antiDiagMatch = false;
                break;
            }
        }

        //check column
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getGrid()[i][col] == null || board.getGrid()[i][col].getType() != board.getGrid()[row][col].getType()) {
                colMatch = false;
                break;
            }
        }
        return rowMatch || colMatch || diagMatch || antiDiagMatch;
    }
}
