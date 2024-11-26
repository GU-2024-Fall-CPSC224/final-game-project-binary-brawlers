package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class GoldenApple extends Food {
    private ImageIcon goldenAppleIcon;

    public GoldenApple(int x, int y) {
        super(x,y);
        loadGoldenAppleIcon(); 
    }

    private void loadGoldenAppleIcon() {
        goldenAppleIcon = new ImageIcon(getClass().getResource("/food/golden.png"));
    }

    @Override
    public void applyAffect(Snake snake) {
        // grows snake by 4 more segments than usual
        for (int i = 0; i < 4; i++) {
            snake.grow();
        }
    }

    public ImageIcon getIcon() {
        return goldenAppleIcon;
    }

    public void draw(Graphics g, int tileSize) {
        if (goldenAppleIcon != null) {
            g.drawImage(goldenAppleIcon.getImage(), getX() * tileSize, getY() * tileSize, null);
        }
    }
}