package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class StarFruit extends Food {
    private ImageIcon starFruitIcon;

    public StarFruit(int x, int y) {
        super(x,y);
        loadStarFruitIcon();
    }

    private void loadStarFruitIcon() {
        starFruitIcon = new ImageIcon(getClass().getResource("/food/star.png"));
    }

    @Override
    public void applyAffect(Snake snake) {
        // sets the snakes invicibility timer to 10 sec (we can change)
        snake.setInvincible(10);
    }

    public ImageIcon getIcon() {
        return starFruitIcon;
    }

    public void draw(Graphics g, int tileSize) {
        if (starFruitIcon != null) {
            g.drawImage(starFruitIcon.getImage(), getX() * tileSize, getY() * tileSize, null);
        }
    }
}