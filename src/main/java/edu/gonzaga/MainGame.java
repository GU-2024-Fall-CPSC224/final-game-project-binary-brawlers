/*
 * Final project main driver class
 * 
 * 
 * Project Description:
 * 
 * 
 * Contributors: Navin Kunakornvanich, Francesca Strickland-Anderson, Cooper Braun, Bradley Russell
 * 
 * 
 * Copyright: 2024
 */
package edu.gonzaga;

import java.util.Scanner;

import javax.swing.JFrame;

/** Main program class for launching your team's program. */
public class MainGame {
    public static void main(String[] args) throws InterruptedException{
        // // intro window (add this stuff to display probably?)
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Display display = new Display();
        frame.add(display);
        display.startMenu(frame);


        // added this section to display
        //wasd to turn
        //enter to tick game
        // Board board = new Board(2);
        // Scanner sc = new Scanner(System.in);
        // while (board.tick()) {
        //     String dir = sc.nextLine();
        //     if (dir == "") {
        //         continue;
        //     }
        //     if (dir.equals("w")) {
        //         board.turnSnake('u');
        //     } else if (dir.equals("a")) {
        //         board.turnSnake('l');
        //     } else if (dir.equals("s")) {
        //         board.turnSnake('d');
        //     } else if (dir.equals("d")) {
        //         board.turnSnake('r');
        //     }
        // }
    }
}
