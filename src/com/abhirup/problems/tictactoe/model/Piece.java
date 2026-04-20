package com.abhirup.problems.tictactoe.model;

import com.abhirup.problems.tictactoe.enums.PieceType;

public class Piece {
    private PieceType type;


    public Piece(PieceType pieceType) {
        this.type = pieceType;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }
}
