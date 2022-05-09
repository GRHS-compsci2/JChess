package com.github.grhscompsci2.JChess;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.grhscompsci2.JChess.util.ChessUtil.Piece;
import com.github.grhscompsci2.JChess.util.listeners.ButtonPressListener;

public class GameBoard extends JPanel {

  // Constants
  private static final GameBoard instance = new GameBoard();
  private static final int rows = 8;
  private static final int cols = 8;

  // Board Colors
  private Color primary = new Color(0xFFFFFF);
  private Color secondary = new Color(0x808080);
  private Color selected = new Color(0x99ff99);

  // Board
  private JButton selectedPiece;
  private JButton[][] board;

  // Fen
  String fen;
  String[] piecePlacement;
  String sideToMove;
  String castling;
  String enPassant;
  String halfMoveClock;
  String fullMoveCounter;

  private GameBoard() {
    setLayout(new GridLayout(rows, cols));

    initBoard();
    drawBoard();
  }

  /**
   * Returns the singleton instance of the GameBoard.
   *
   * @return the singleton instance of the GameBoard
   */
  public static GameBoard getInstance() {
    return instance;
  }

  /**
   * Initializes the board with buttons, buttons have a listener attached to them.
   * Adds the buttons to this panel.
   */
  public void initBoard() {
    board = new JButton[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = new JButton(/* (char)('A' + j) + "" + (cols - i) */);
        board[i][j].addActionListener(new ButtonPressListener(board[i][j]));
        add(board[i][j]);
      }
    }
  }

  /**
   * Draws the board. Used to update the board when colors need to go back to prim
   * and sec.
   */
  public void drawBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (i % 2 == 0) {
          if (j % 2 == 0) {
            board[i][j].setBackground(primary);
          } else {
            board[i][j].setBackground(secondary);
          }
        } else {
          if (j % 2 == 0) {
            board[i][j].setBackground(secondary);
          } else {
            board[i][j].setBackground(primary);
          }
        }
      }
    }
  }

  /**
   * Sets the primary color of the board.
   *
   * @param c the color to set the board to
   */
  public void setPrimary(Color c) {
    primary = c;
    drawBoard();
  }

  /**
   * Sets the secondary color of the board.
   *
   * @param c the color to set the board to
   */
  public void setSecondary(Color c) {
    secondary = c;
    drawBoard();
  }

  /**
   * Sets the selected color of the board.
   *
   * @param c the color to set the board to
   */
  public void setSelected(Color c) {
    selected = c;
    drawBoard();
  }

  /**
   * Gets the primary color of the board.
   *
   * @return the primary color of the board
   */
  public int getPrimary() {
    return primary.getRGB();
  }

  /**
   * Gets the secondary color of the board.
   *
   * @return the secondary color of the board
   */
  public int getSecondary() {
    return secondary.getRGB();
  }

  /**
   * Gets the selected color of the board.
   *
   * @return the selected color of the board
   */
  public int getSelected() {
    return selected.getRGB();
  }

  /**
   * Sets the newly selected piece.
   * If the piece is not null, it will be set to the selected color.
   *
   * @param b the piece to set to selected
   */
  public void setSelectedPiece(JButton b) {
    selectedPiece = b;
    if (selectedPiece != null) {
      selectedPiece.setBackground(selected);
    }
  }

  /**
   * Will unselect a piece if one is currently selected.
   *
   */
  public void unsetSelectedPiece() {
    if (selectedPiece != null) {
      drawBoard();
      selectedPiece = null;
    }
  }

  /**
   * Gets the currently selected piece.
   *
   * @return the selected peice
   */
  public JButton getSelectedPiece() {
    return selectedPiece;
  }

  /**
   * Replaces selected piece icon with null.
   * sets button to selected pieces icon.
   *
   * @param button the button that will be replaced with selected piece's icon.
   */
  public void movePiece(JButton button) {
    // FIXME: check that move is legal

    button.setIcon(selectedPiece.getIcon());
    selectedPiece.setIcon(null);
    unsetSelectedPiece();

    drawBoard();
  }

  /**
   * Sets the board up according to the fen string.
   *
   * @param fen the fen string to set the board up with
   */
  public void inputFenString(String fen) {
    // System.out.println(fen);
    piecePlacement = fen.split("/"); // will split the piece placement into entries, but last entry has the remaining
    // of the fen string so it needs to be dropped off.
    piecePlacement[7] = piecePlacement[7].split(" ")[0]; // drop the remaining of fen

    String[] fenInfo = fen.split(" "); // will split the last, just ignore the first entry as its piece placement.
    sideToMove = fenInfo[1];
    castling = fenInfo[2];
    enPassant = fenInfo[3];
    halfMoveClock = fenInfo[4];
    fullMoveCounter = fenInfo[5];

    // setup board
    for (int i = 0; i < 8; i++) {
      ArrayList<Character> pieces = new ArrayList<Character>();
      // add all pieces to the arraylist
      for (int j = 0; j < piecePlacement[i].length(); j++) {
        pieces.add(piecePlacement[i].charAt(j));
      }

      for (int j = 0; j < 8; j++) {
        // get next piece
        char c = pieces.remove(0);
        switch (c) {
          case 'p': {
            board[i][j].setIcon(Piece.BLACK_PAWN.icon);
            break;
          }
          case 'r': {
            board[i][j].setIcon(Piece.BLACK_ROOK.icon);
            break;
          }
          case 'n': {
            board[i][j].setIcon(Piece.BLACK_KNIGHT.icon);
            break;
          }
          case 'b': {
            board[i][j].setIcon(Piece.BLACK_BISHOP.icon);
            break;
          }
          case 'q': {
            board[i][j].setIcon(Piece.BLACK_QUEEN.icon);
            break;
          }
          case 'k': {
            board[i][j].setIcon(Piece.BLACK_KING.icon);
            break;
          }
          case 'P': {
            board[i][j].setIcon(Piece.WHITE_PAWN.icon);
            break;
          }
          case 'R': {
            board[i][j].setIcon(Piece.WHITE_ROOK.icon);
            break;
          }
          case 'N': {
            board[i][j].setIcon(Piece.WHITE_KNIGHT.icon);
            break;
          }
          case 'B': {
            board[i][j].setIcon(Piece.WHITE_BISHOP.icon);
            break;
          }
          case 'Q': {
            board[i][j].setIcon(Piece.WHITE_QUEEN.icon);
            break;
          }
          case 'K': {
            board[i][j].setIcon(Piece.WHITE_KING.icon);
            break;
          }
          default: {
            j += Integer.valueOf(String.valueOf(c));
          }
        }
      }
    }
  }

  /**
   * Gets the fen string of the board.
   *
   * @return the fen string of the board
   */
  public String exportFenString() {
    return "";
  }
}
