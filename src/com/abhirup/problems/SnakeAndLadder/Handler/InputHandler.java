package com.abhirup.problems.SnakeAndLadder.Handler;

import java.util.Scanner;

public class InputHandler {
    private final Scanner sc;

    public InputHandler(Scanner sc) {
        this.sc = sc;
    }

    public int nextInt() {
        return sc.nextInt();
    }

    public String next() {
        return sc.next();
    }
}
