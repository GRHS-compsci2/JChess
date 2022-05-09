package io.github.daflamingfox.util.listeners;

import io.github.daflamingfox.GameBoard;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

public class SecondaryColorListener implements SimpleDocumentListener {

  JTextField text;

  public SecondaryColorListener(JTextField text) {
    this.text = text;
  }

  /**
   * update gameboard color if text is valid
   */
  @Override
  public void update(DocumentEvent e) {
    String input = text.getText();

    // stop if not a code yet.
    if (input.trim().length() != 6) {
      return;
    }

    try {
      int hexCode = Integer.parseInt(input, 16);
      if (hexCode > 0xFFFFFF) {
        hexCode = 0xFFFFFF;
      } else if (hexCode < 0x000000) {
        hexCode = 0x000000;
      }
      GameBoard.getInstance().setSecondary(new Color(hexCode));
    } catch (NumberFormatException ex) {
      // ignore
    }
  }
}
