package edu.gonzaga;

public class GoldenApple extends Food {
    public GoldenApple(int x, int y) {
        super(x,y);
    }

    @Override
    public void applyAffect(Snake snake) {
        // grows snake by 4 more segments than usual
        for (int i = 0; i < 4; i++) {
            snake.grow();
        }
    }
}