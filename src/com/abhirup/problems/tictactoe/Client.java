package com.abhirup.problems.tictactoe;

import com.abhirup.problems.tictactoe.enums.PieceType;
import com.abhirup.problems.tictactoe.model.Board;
import com.abhirup.problems.tictactoe.model.Piece;
import com.abhirup.problems.tictactoe.model.Player;
import com.abhirup.problems.tictactoe.strategy.AllCheckStrategy;

import java.util.ArrayDeque;
import java.util.List;

public class Client {
    //TODO: Implement the client class to interact with the TicTacToe game.
    //create 2 players and start the game.
        public static void main(String[] args) {
            Player player1 = new Player("Player 1", new Piece(PieceType.X),0);
            Player player2 = new Player("Player 2", new Piece(PieceType.Y),0);
            //we will play the game in the console, so we will not implement the UI part, we will just print the board and ask for the input from the user.
            //we will play for 5 rounds and keep track of the score of the players, at the end of the 5 rounds we will declare the winner.
            for(int i=0;i<2;i++){
                System.out.println("Round "+(i+1));
                TicTacToeGame game = new TicTacToeGame(3, new ArrayDeque<>(List.of(player1, player2)),new AllCheckStrategy());
                System.out.println("This round result is : "+ game.startGame());
            }
            System.out.println("Final Score: "+player1.getName()+"-"+player1.getScore()+" "+player2.getName()+"-"+player2.getScore());
        }
}
