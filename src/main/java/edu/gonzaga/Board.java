package edu.gonzaga;

import java.util.ArrayList;
import java.util.Map;

public class Board {
    private int width = 17;
    private int height = 17;
    private Snake snake;
    private ArrayList<Obstacle> obstacles;
    private Food food;
    private int score = 0;

    //easy = 0, medium = 2, hard = 5
    public Board(int numObstacles) {
        snake = new Snake();
        food = new Food(12, 7);
        obstacles = new ArrayList<>();
        for (int i = 0; i < numObstacles; i++) {
            obstacles.add(new Obstacle((int)(Math.random() * width), (int)(Math.random() * height)));
        }
    }

    //main game loop, called on a time interval
    //returns false if the snake dies
    public boolean tick() {
        snake.move();
        switch (detectCollision(snake)) {
            case "food":
            score++;
            snake.grow();
            food.applyAffect(snake);
            makeNewFood();
            break;
            case "edge":
            case "obstacle":
            case "snake":
            if (snake.getInvincible() == 0) {
                return false;
            } else {
                keepInBounds();
            }
        }
        System.out.println(this);
        return true;
    }
    
    //called from keyboard listener
    public void turnSnake(char dir) {
        snake.turn(dir);
    }

    //takes in a board element and returns if it collides with anything, if not returns empty string
    //used for snake dying and setting new food pos
    public String detectCollision(BoardElement object) {
        if (object.getX() < 0 || object.getY() < 0 || object.getX() >= width || object.getY() >= height) {
            return "edge";
        }
        for (Obstacle o : obstacles) {
            if (object.getX() == o.getX() && object.getY() == o.getY()) {
                return "obstacle";
            }
        }
        for (SnakeSegment s : snake.getSegments()) {
            if (object.getX() == s.getX() && object.getY() == s.getY()) {
                return "snake";
            }
        }
        if (object.getX() == food.getX() && object.getY() == food.getY()) {
            return "food";
        }
        return "";
    }

    private void makeNewFood() {
        do {
            //todo: randomize type
            food = new Food((int)(Math.random() * 17), (int)(Math.random() * 17));
        } while (detectCollision(food) == "obstacle" || detectCollision(food) == "snake");
    }
    
    private void keepInBounds() {
        snake.setX((snake.getX() + width) % width);
        snake.setY((snake.getY() + height) % height);
    }

    //print board to console for testing
    public String toString() {
        StringBuilder gameStr = new StringBuilder();
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                gameStr.append("`");
            }
            gameStr.append("\n");
        }
        gameStr.setCharAt(food.getY() * 18 + food.getX(), 'F');
        for (Obstacle o : obstacles) {
            int index = o.getY() * 18 + o.getX();
            gameStr.setCharAt(index, 'O');
        }
        for (SnakeSegment s : snake.getSegments()) {
            int index = s.getY() * 18 + s.getX();
            gameStr.setCharAt(index, s.getRotAsChr());
        }
        char headChr = Map.of('u','^','d','v','l','<','r','>').get(snake.getFacing());
        gameStr.setCharAt(snake.getY() * 18 + snake.getX(), headChr);
        gameStr.append("Score: " + score + "\n");
        return gameStr.toString();
    }
}
