package com.abhirup.problems.tictactoe.model;

public class Player {
    private String name;
    private Piece piece;
    private int score;

    public Player(String name, Piece piece, int score) {
        this.name = name;
        this.piece = piece;
        this.score = score;
    }

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
