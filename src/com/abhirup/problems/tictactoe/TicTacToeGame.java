package com.abhirup.problems.tictactoe;

import com.abhirup.problems.tictactoe.model.Board;
import com.abhirup.problems.tictactoe.model.Player;
import com.abhirup.problems.tictactoe.strategy.WinningStrategy;

import java.util.Deque;
import java.util.Scanner;

public class TicTacToeGame {
    Board board;
    Deque<Player> players;
    WinningStrategy winningStrategy;

    public TicTacToeGame(int size, Deque<Player> players,WinningStrategy winningStrategy) {
         this.winningStrategy = winningStrategy;
        this.board = new Board(size);
        this.players = players;
    }

    public String startGame(){
        boolean gameOver = false;
        while (!gameOver) {
            Player currentPlayer = players.removeFirst();
            //for user to check the free space in board
            board.printBoard();
            //check if the board is full
            if (board.isFull()) {
                gameOver = true;
                continue;
            }
            System.out.print("\n");
            //Read the user input for the row and column where they want to place their piece, we will use scanner for this
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            boolean isValid = board.addPiece(x, y, currentPlayer.getPiece());
            if (!isValid) {
                System.out.println("Invalid move, try again");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);
            boolean isWin = winningStrategy.checkWin(x,y,board);
            if (isWin) {
                currentPlayer.setScore(currentPlayer.getScore() + 1);
                return "Winner is "+currentPlayer.getName();
            }
        }
        return "Tie";
    }
}
