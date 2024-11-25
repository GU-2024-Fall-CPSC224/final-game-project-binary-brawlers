package edu.gonzaga;

import java.util.Scanner;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel implements ActionListener {

    private static final int game_width = 1000;
    private static final int game_height = 1000;
    int gameSpeed = 100;

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    // panel
    public Display() {
            setPreferredSize(new Dimension(game_width, game_height));
            setBackground(Color.green);
        }

        
        public void startMenu(JFrame frame) {
            JPanel startWindow = new JPanel();
            startWindow.setBackground(Color.black);
    
            // layout
            startWindow.add(Box.createRigidArea(new Dimension(0, 50)));
            JLabel title = new JLabel("SNAKE");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            startWindow.add(title);
    
            // different levels for boards here ?
    
            // options for different speeds
            startWindow.add(Box.createRigidArea(new Dimension(0, 20)));
    
            JButton speed1 = new JButton("Easy");
            speed1.addActionListener(event -> gameSpeed = 150);
            startWindow.add(speed1);
    
            JButton speed2 = new JButton("Normal");
            speed2.addActionListener(event -> gameSpeed = 100);
            startWindow.add(speed2);
    
            JButton speed3 = new JButton("Hard");
            speed3.addActionListener(event -> gameSpeed = 80);
            startWindow.add(speed3);
    
            frame.add(startWindow);
            frame.pack();
            frame.setVisible(true);
        }
   
}
