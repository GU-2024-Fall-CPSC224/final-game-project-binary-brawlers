/*
 * Final project main driver class
 * 
 * 
 * Project Description:
 * 
 * 
 * Contributors: Cooper Braun, Navin Kunakornvanich, Francesca Strickland-Anderson, Bradley Russell
 * 
 * 
 * Copyright: 2024
 */
package edu.gonzaga;

import javax.swing.Timer;

/** Main program class for launching your team's program. */
public class MainGame {
    public static void main(String[] args) {
        // // intro window (add this stuff to display probably?)
        // JFrame frame = new JFrame("Snake Game");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setResizable(false);

        // Display display = new Display();
        // frame.add(display);
        // display.startMenu(frame);


        //wasd to turn
        //enter to tick game
        Board board = new Board(2);
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                // create graphical layout
                BoardLayout layout = new BoardLayout(board);

                //timer to control snake movement/game updates
                new Timer (300, e -> {
                    if (!board.tick()) {
                        System.out.println("Game Over!");
                        ((Timer) e.getSource()).stop();
                    } else {
                        layout.updateGame();
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
