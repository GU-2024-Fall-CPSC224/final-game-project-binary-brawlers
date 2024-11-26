package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

//This should also have a keyboard listener that calls snake.turn
//and a timer that calls 
public class GridLayoutExample extends JFrame {
    private Timer timer;
    private JLabel timerLabel;
    private int elapsedTime;

    public GridLayoutExample() throws IOException {

        // Set up the JFrame
        super("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(17*50, 15*50+18);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel timerPanel = new JPanel();
        timerPanel.setBackground(Color.LIGHT_GRAY);
        timerLabel = new JLabel("Time: 0 seconds");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerPanel.add(timerLabel);
        mainPanel.add(timerPanel, BorderLayout.NORTH);
        
        // Create a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(15, 17));
        panel.setBackground(Color.decode("#578A34"));

        // Create text labels for the rest of the grid
        ArrayList<JLabel> tiles = new ArrayList<>();
        for (int i = 0; i < 15*17; i++) {
            JLabel label = new JLabel();
            label.setSize(50, 50);
            label.setOpaque(true);
            label.setBackground(Color.decode(i % 2 == 0 ? "#A7D948" : "#8ECC39"));
            tiles.add(label);
            panel.add(label);
        }
        //tiles.get(3+8*15).setIcon(new ImageIcon(ImageIO.read(new File("./hr.png"))));

        mainPanel.add(panel, BorderLayout.CENTER);
        // Set the content pane of the JFrame
        setContentPane(panel);
        
        timerStart();

        // Make the JFrame visible
        setVisible(true);
    }

    private void timerStart(){
        elapsedTime = 0;
        timer = new Timer(1000, e -> updateTimer());
        timer.start();
    }

    private void updateTimer() {
        elapsedTime++;
        timerLabel.setText("Time:" + elapsedTime);
    }

    public static void main(String[] args) throws IOException {
        new GridLayoutExample();
    }
}