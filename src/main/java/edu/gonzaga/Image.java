package edu.gonzaga;

import javax.swing.*;

public class Image extends JFrame {
    
    JFrame frame;
    JLabel displayField;
    ImageIcon image;

    public Image() {

        frame = new JFrame("Display Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            image  = new ImageIcon(getClass().getResource("/food/apple.png"));
            displayField = new JLabel(image);
            frame.add(displayField);
        } catch(Exception e) {
            System.out.println("not found");
        }
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Image();
    }
}
