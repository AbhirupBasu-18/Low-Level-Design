package com.abhirup.problems.tictactoe.strategy;

import com.abhirup.problems.tictactoe.model.Board;

public interface WinningStrategy {
    boolean checkWin(int row, int col, Board board);
}
