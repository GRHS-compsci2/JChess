package io.github.daflamingfox;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame {

  private JPanel gameBoard = GameBoard.getInstance();
  private JPanel debug = new Debug();

  public App() {
    setTitle("Chess");
    setSize(800, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // add panels
    add(gameBoard, BorderLayout.CENTER);
    add(debug, BorderLayout.NORTH);

    //pack();
    setVisible(true);
  }
}
