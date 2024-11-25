package edu.gonzaga;

public class StarFruit extends Food {
    public StarFruit(int x, int y) {
        super(x,y);
    }

    @Override
    public void applyAffect(Snake snake) {
        // sets the snakes invicibility timer to 10 sec (we can change)
        snake.setInvincible(10);
    }
}