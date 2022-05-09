package com.github.grhscompsci2.JChess;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) throws Exception {
    // creates a new instance of the App on a new thread like a good little program
    SwingUtilities.invokeLater(
      new Runnable() {
        @Override
        public void run() {
          new App();
        }
      }
    );
  }
}
