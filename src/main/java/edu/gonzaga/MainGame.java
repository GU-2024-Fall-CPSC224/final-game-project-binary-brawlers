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
import javax.swing.JFrame;

/** Main program class for launching your team's program. */
public class MainGame {
    public static void main(String[] args) throws InterruptedException{
        // intro window (add this stuff to display probably?)
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        Display display = new Display();
        display.startMenu(frame);
    }
}
