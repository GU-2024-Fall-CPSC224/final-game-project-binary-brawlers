package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class Apple extends Food {
    private ImageIcon appleIcon;

    public Apple (int x, int y) {
        super (x,y);
        loadAppleIcon(); 
    }

    private void loadAppleIcon() {
        appleIcon = new ImageIcon(getClass().getResource("/food/apple.png"));
    }

    @Override
    public void applyAffect(Snake snake) {
        // regular apple does not apply any special effects
    }

    public ImageIcon getIcon() {
        return appleIcon;
    }

    public void draw(Graphics g, int tileSize) {
        if (appleIcon != null) {
            g.drawImage(appleIcon.getImage(), getX() * tileSize, getY() * tileSize, null);
        }
    }
}