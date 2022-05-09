package io.github.daflamingfox.util.listeners;

import io.github.daflamingfox.GameBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonPressListener implements ActionListener {

  private JButton button;

  public ButtonPressListener(JButton button) {
    this.button = button;
  }

  /**
   * logic to figure out what pieces need to be compared, but not what to do with them.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    // check if another piece is selected
    if (GameBoard.getInstance().getSelectedPiece() != null) {
      // unselect piece.
      if (GameBoard.getInstance().getSelectedPiece() == button) {
        GameBoard.getInstance().unsetSelectedPiece();
        return;
      } else {
        // second selection, move piece
        GameBoard.getInstance().movePiece(button);
      }
    } else {
      // first selection, set piece.
      GameBoard.getInstance().setSelectedPiece(button);
    }
  }
}
