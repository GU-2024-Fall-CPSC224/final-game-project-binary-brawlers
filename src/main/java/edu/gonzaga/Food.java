package edu.gonzaga;

public class Food extends BoardElement{

    //todo:
    // make food an abstract class
    // make 3 food subclasses: apple, goldenApple, starFruit
    // apple does no affect
    // goldenApple grows snake 4 more times
    // starFruit sets snake's invincibility timer (maybe some indicator of this?)
    public Food(int x, int y) {
        super(x, y);
    }

    public void applyAffect(Snake snake) {

    }
}
