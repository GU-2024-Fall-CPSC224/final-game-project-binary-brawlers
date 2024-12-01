package edu.gonzaga;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

public class Display extends JPanel implements ActionListener {
    private int GAME_WIDTH = 1000;
    private int GAME_HEIGHT = 1000;

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
        frame.setSize(1000, 1000);
        frame.setResizable(false);

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
        frame.setLocationRelativeTo(null);
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
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                // create graphical layout
                BoardLayout layout = new BoardLayout(board);

                //timer to control snake movement/game updates
                new Timer (200, e -> {
                    board.turnSnake(board.getSnake().getFacing());
                    if (!board.tick()) {
                        gameOverMenu();
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

    public void gameOverMenu() {
        JFrame frame = new JFrame("Game Over");
        frame.setSize(GAME_WIDTH, GAME_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JPanel gameOverPanel = new JPanel();
        gameOverPanel.setLayout(new BoxLayout(gameOverPanel, BoxLayout.Y_AXIS));
        gameOverPanel.setBackground(Color.black);
    
        // title
        JLabel gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameOverLabel.setForeground(Color.red);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 48));
        gameOverPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        gameOverPanel.add(gameOverLabel);
    
        // try again button
        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // restarts 
        tryAgainButton.addActionListener(event -> {
            frame.dispose(); 
            startGame(); 
        });
    
        // returns to main menu
        JButton menuButton = new JButton("Main Menu");
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.addActionListener(event -> {
            frame.dispose();
            JFrame mainMenuFrame = new JFrame("Snake Game");
            mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startMenu(mainMenuFrame);
        });
    
        // exits
        JButton exitButton = new JButton("Exit Game");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(event -> System.exit(0));

        gameOverPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        gameOverPanel.add(tryAgainButton);
        gameOverPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameOverPanel.add(menuButton);
        gameOverPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameOverPanel.add(exitButton);

        frame.add(gameOverPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    // private void restartMenu(JFrame frame) {
    //     frame.getContentPane().removeAll();
    //     startMenu(frame);
    //     frame.revalidate();
    // }
}
