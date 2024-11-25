package edu.gonzaga;

public abstract class Food extends BoardElement {
    public Food (int x, int y) {
        super(x,y);
    }
    // applies the effect of the food on the snake
    public abstract void applyAffect(Snake snake);
}