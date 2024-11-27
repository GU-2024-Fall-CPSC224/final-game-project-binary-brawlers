package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//This should also have a keyboard listener that calls snake.turn
//and a timer that calls 
public class GridLayoutExample extends JFrame {
    public GridLayoutExample() throws IOException {
        // Set up the JFrame
        super("Brawl Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(17*50, 15*50+50);
        setResizable(false);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BorderLayout());
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scorePanel.add(scoreLabel, BorderLayout.NORTH);
        add(scoreLabel, BorderLayout.NORTH);

        // Create a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(15, 17));
        panel.setBackground(Color.decode("#578A34"));

        // Create text labels for the rest of the grid
        ArrayList<JLabel> tiles = new ArrayList<>();
        for (int i = 0; i < 15*17; i++) {
            JLabel label = new JLabel();
            label.setSize(50, 50);
            label.setOpaque(true);
            label.setBackground(Color.decode(i % 2 == 0 ? "#d4a276" : "#bc8a5f"));
            tiles.add(label);
            panel.add(label);
        }
        //tiles.get(3+815).setIcon(new ImageIcon(ImageIO.read(new File("./hr.png"))));
        add(panel, BorderLayout.CENTER);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new GridLayoutExample();
    }
} 