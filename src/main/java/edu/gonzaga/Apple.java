package edu.gonzaga;

public class Apple extends Food {
    public Apple (int x, int y) {
        super (x,y);
    }
    @Override
    public void applyAffect(Snake snake) {
        // regular apple does not apply any special effects
    }
}