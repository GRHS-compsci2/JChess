package io.github.daflamingfox;

import io.github.daflamingfox.util.listeners.PrimaryColorListener;
import io.github.daflamingfox.util.listeners.SecondaryColorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Debug extends JPanel {

  private SpringLayout layout = new SpringLayout();

  private JLabel primaryColorLabel;
  private JTextField primaryColorValue;

  private JLabel secondaryColorLabel;
  private JTextField secondaryColorValue;

  private JButton gameStarter;

  public Debug() {
    setLayout(layout);

    // Containers
    setupPrimary();
    setupSecondary();
    setupGameStarter();

    // Constraints
    layout.putConstraint(SpringLayout.SOUTH, this, 10, SpringLayout.SOUTH, gameStarter); // 10 away from bottom
    layout.putConstraint(
      SpringLayout.EAST,
      this,
      10,
      SpringLayout.EAST,
      secondaryColorValue
    ); // 10 away from right
  }

  /**
   * Setup the primary color container.
   */
  private void setupPrimary() {
    // Containers
    primaryColorLabel = new JLabel("Primary Board Color:");
    primaryColorValue = new JTextField("808080", 6);
    primaryColorValue
      .getDocument()
      .addDocumentListener(new PrimaryColorListener(primaryColorValue));

    // Constraints
    layout.putConstraint(
      SpringLayout.NORTH,
      primaryColorLabel,
      10,
      SpringLayout.NORTH,
      this
    ); // 10 away from top
    layout.putConstraint(
      SpringLayout.WEST,
      primaryColorLabel,
      10,
      SpringLayout.WEST,
      this
    ); // 10 away from side
    add(primaryColorLabel);

    layout.putConstraint(
      SpringLayout.NORTH,
      primaryColorValue,
      0,
      SpringLayout.NORTH,
      primaryColorLabel
    ); // top aligned with label
    layout.putConstraint(
      SpringLayout.WEST,
      primaryColorValue,
      3,
      SpringLayout.EAST,
      primaryColorLabel
    ); // 3 away from label
    add(primaryColorValue);
  }

  /**
   * Setup the secondary color container.
   */
  private void setupSecondary() {
    // Containers
    secondaryColorLabel = new JLabel("Secondary Board Color:");
    secondaryColorValue = new JTextField("808080", 6);
    secondaryColorValue
      .getDocument()
      .addDocumentListener(new SecondaryColorListener(secondaryColorValue));

    // Constraints
    layout.putConstraint(
      SpringLayout.NORTH,
      secondaryColorLabel,
      10,
      SpringLayout.SOUTH,
      primaryColorLabel
    ); // 10 away from label
    layout.putConstraint(
      SpringLayout.WEST,
      secondaryColorLabel,
      0,
      SpringLayout.WEST,
      primaryColorLabel
    ); // left aligned with label
    add(secondaryColorLabel);

    layout.putConstraint(
      SpringLayout.NORTH,
      secondaryColorValue,
      0,
      SpringLayout.NORTH,
      secondaryColorLabel
    ); // top aligned with label
    layout.putConstraint(
      SpringLayout.WEST,
      secondaryColorValue,
      3,
      SpringLayout.EAST,
      secondaryColorLabel
    ); // 3 away from label
    add(secondaryColorValue);
  }

  /**
   * Setup the start game button.
   */
  private void setupGameStarter() {
    // Containers
    gameStarter = new JButton("Start Game");
    gameStarter.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          GameBoard
            .getInstance()
            .inputFenString("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        }
      }
    );

    // Constraints
    layout.putConstraint(
      SpringLayout.NORTH,
      gameStarter,
      10,
      SpringLayout.SOUTH,
      secondaryColorLabel
    ); // 10 away from label
    layout.putConstraint(
      SpringLayout.WEST,
      gameStarter,
      0,
      SpringLayout.WEST,
      secondaryColorLabel
    ); // left aligned with label
    add(gameStarter);
  }
}
