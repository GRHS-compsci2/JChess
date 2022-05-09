package com.github.grhscompsci2.JChess.util;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ChessUtil {

  // Gets the Icon for the given piece.
  public enum Piece {
    WHITE_PAWN("whitePawn"),
    WHITE_ROOK("whiteRook"),
    WHITE_KNIGHT("whiteKnight"),
    WHITE_BISHOP("whiteBishop"),
    WHITE_QUEEN("whiteQueen"),
    WHITE_KING("whiteKing"),
    BLACK_PAWN("blackPawn"),
    BLACK_ROOK("blackRook"),
    BLACK_KNIGHT("blackKnight"),
    BLACK_BISHOP("blackBishop"),
    BLACK_QUEEN("blackQueen"),
    BLACK_KING("blackKing");

    public StretchIcon icon;

    private Piece(String name) {
      icon = new StretchIcon("src/com/github/grhscompsci2/JChess/images/"+name+".png");
    }
  }
}
