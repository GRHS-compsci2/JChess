package io.github.daflamingfox.util.listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Shortify the document listener
 * https://stackoverflow.com/a/39390467
 */
public interface SimpleDocumentListener extends DocumentListener {
  void update(DocumentEvent e);

  /**
   * just call update
   */
  @Override
  default void insertUpdate(DocumentEvent e) {
    update(e);
  }

  /**
   * just call update
   */
  @Override
  default void removeUpdate(DocumentEvent e) {
    update(e);
  }

  /**
   * just call update
   */
  @Override
  default void changedUpdate(DocumentEvent e) {
    update(e);
  }
}
