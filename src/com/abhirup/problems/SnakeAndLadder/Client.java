package com.abhirup.problems.SnakeAndLadder;

import com.abhirup.problems.SnakeAndLadder.Handler.InputHandler;
import com.abhirup.problems.SnakeAndLadder.model.Board;

import com.abhirup.problems.SnakeAndLadder.model.Dice;
import com.abhirup.problems.SnakeAndLadder.model.Player;
import com.abhirup.problems.SnakeAndLadder.model.SnakeAndLadderGame;
import com.abhirup.problems.SnakeAndLadder.strategy.BoardInitializationStrategy;
import com.abhirup.problems.SnakeAndLadder.strategy.RandomStrategy;
import com.abhirup.problems.SnakeAndLadder.strategy.UserInputStrategy;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //we will select strategy pattern to select the type of dice we want to play with and factory pattern to create the dice object
        Scanner sc = new Scanner(System.in);
        InputHandler input = new InputHandler(sc);
        System.out.println("Enter board size:");
        int size = input.nextInt();
        System.out.println("Enter number of snakes:");
        int noOfSnakes = input.nextInt();
        System.out.println("Enter number of ladders:");
        int noOfLadders = input.nextInt();
        System.out.println("Enter number of dices u want to play:");
        int noOfDices = input.nextInt();
        
        System.out.println("\nChoose strategy for board initialization:");
        System.out.println("1. Random Strategy (auto-generated snakes and ladders)");
        System.out.println("2. User Input Strategy (enter positions manually)");
        System.out.print("Enter your choice (1 or 2): ");
        int strategyChoice = input.nextInt();
        
        // Create strategy based on user choice
        BoardInitializationStrategy strategy;
        if (strategyChoice == 1) {
            strategy = new RandomStrategy();
            System.out.println("\n--- Using Random Strategy ---\n");
        } else {
            strategy = new UserInputStrategy(input);
            System.out.println("\n--- Using User Input Strategy ---\n");
        }
        
        Dice dice = new Dice(noOfDices);
        Board board = new Board(size, noOfSnakes, noOfLadders, strategy);
        Player player1 = new Player("Abhirup",0);
        Player player2 = new Player("Shyam",0);
        Queue<Player> playerList = new ArrayDeque<>(List.of(player1, player2));
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(board,playerList,dice);
        snakeAndLadderGame.startPlay();
    }
}
