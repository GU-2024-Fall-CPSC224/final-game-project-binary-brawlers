package edu.gonzaga;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

public class Display extends JPanel implements ActionListener {
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 800;

    // defaults and intialize
    private int gameSpeed = 100;
    private int obstacle = 0;
    private boolean speedSelected = false;
    private boolean obstacleSelected = false;

    public Display() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        setBackground(Color.green);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // add later
    }

    public void startMenu(JFrame frame) {
        JPanel startWindow = new JPanel();
        startWindow.setLayout(new BoxLayout(startWindow, BoxLayout.Y_AXIS));
        startWindow.setBackground(Color.black);

        // title
        JLabel title = new JLabel("SNAKE GAME");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        startWindow.add(Box.createRigidArea(new Dimension(0, 20)));
        startWindow.add(title);

        // game settings
        selection("Select Speed:", startWindow);
        startWindow.add(speedButtons());

        selection("Select Obstacles:", startWindow);
        startWindow.add(obstacleButtons());

        // start game button
        JButton startGame = new JButton("Start Game");
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGame.addActionListener(event -> {
            if (!speedSelected || !obstacleSelected) {
                JOptionPane.showMessageDialog(frame, "Select both speed and obstacle level.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                frame.dispose();
                startGame();
            }
        });
        startWindow.add(Box.createRigidArea(new Dimension(0, 20)));
        startWindow.add(startGame);

        frame.add(startWindow);
        frame.pack();
        frame.setVisible(true);
    }

    private void selection(String text, JPanel panel) {
        JLabel subtitle = new JLabel(text);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setForeground(Color.white);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(subtitle);
    }

    // speed settings
    private JPanel speedButtons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.setBackground(Color.black);

        JButton easy = new JButton("Easy");
        easy.addActionListener(event -> {
            gameSpeed = 150;
            speedSelected = true;
        });

        JButton normal = new JButton("Normal");
        normal.addActionListener(event -> {
            gameSpeed = 100;
            speedSelected = true;
        });

        JButton hard = new JButton("Hard");
        hard.addActionListener(event -> {
            gameSpeed = 80;
            speedSelected = true;
        });

        buttons.add(easy);
        buttons.add(normal);
        buttons.add(hard);

        return buttons;
    }

    // obstacle settings
    private JPanel obstacleButtons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.setBackground(Color.black);

        JButton easy = new JButton("Easy");
        easy.addActionListener(event -> {
            obstacle = 0;
            obstacleSelected = true;
        });

        JButton medium = new JButton("Medium");
        medium.addActionListener(event -> {
            obstacle = 2;
            obstacleSelected = true;
        });

        JButton hard = new JButton("Hard");
        hard.addActionListener(event -> {
            obstacle = 5;
            obstacleSelected = true;
        });

        buttons.add(easy);
        buttons.add(medium);
        buttons.add(hard);

        return buttons;
    }

    private void startGame() {
        System.out.println("Speed: " + gameSpeed + " | Obstacles: " + obstacle);
        // WILL HAVE TO IMPLEMENT A WAY TO CHANGE SPEED
        Board board = new Board(obstacle);
        Scanner sc = new Scanner(System.in);
        while (board.tick() == true) {
            String dir = sc.nextLine();
            if (dir == "") {
                continue;
            }
            if (dir.equals("w")) {
                board.turnSnake('u');
            } else if (dir.equals("a")) {
                board.turnSnake('l');
            } else if (dir.equals("s")) {
                board.turnSnake('d');
            } else if (dir.equals("d")) {
                board.turnSnake('r');
            }
        }
    }

    public void gameOverMenu(JFrame frame) {
        String[] options = {"Try Again", "Menu", "Exit"};
        int choice = JOptionPane.showOptionDialog(this, "GAME OVER", "Snake Game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

         // try again
         if (choice == 0) {
            // resetGame();
        }
        // go to menu
        if (choice == 1) {
            exitGame();
        }
        // close window
        if (choice == 2) {
            System.exit(0);
        }
    }

    // private void restartMenu(JFrame frame) {
    //     frame.getContentPane().removeAll();
    //     startMenu(frame);
    //     frame.revalidate();
    // }
}
