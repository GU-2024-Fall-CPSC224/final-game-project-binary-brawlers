package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GridLayoutExample extends JFrame {
    private Board board;
    private JLabel scoreLabel;
    private JLabel timerLabel;
    private int timeElapsed;

    public GridLayoutExample(Board board) throws IOException {
        this.board = board;
        this.timeElapsed = 0;
        // Set up the JFrame
        setTitle("Brawl Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(17 * 50, 15 * 50 + 50);
        setResizable(false);

        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new BorderLayout());

        scoreLabel = new JLabel("Score: " + board.getScore());
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        borderPanel.add(scoreLabel, BorderLayout.WEST);

        timerLabel = new JLabel("Time: " + timeElapsed, JLabel.RIGHT);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        borderPanel.add(timerLabel, BorderLayout.EAST);
        
        add(borderPanel, BorderLayout.NORTH);

        // Create a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(15, 17));

        // Create text labels for the rest of the grid
        ArrayList<JLabel> tiles = new ArrayList<>();
        for (int i = 0; i < 15 * 17; i++) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setPreferredSize(new Dimension(50, 50));
            label.setBackground(Color.decode(i % 2 == 0 ? "#d4a276" : "#bc8a5f"));
            tiles.add(label);
            panel.add(label);
        }

        add(panel, BorderLayout.CENTER);

        // Make the JFrame visible
        setVisible(true);

        // Set up timer
        new Timer(1000, e -> updateGame()).start();
    }

    private void updateGame() {
        // Update the game state (e.g., move the snake, check collisions)
        // Update the score
        scoreLabel.setText("Score: " + board.getScore());
        timeElapsed++;
        timerLabel.setText("Time: " + timeElapsed);
    }

    public static void main(String[] args) throws IOException {
        Board board = new Board(5);
        new GridLayoutExample(board);
    }
}
