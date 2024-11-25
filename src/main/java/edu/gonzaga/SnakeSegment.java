package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SnakeSegment extends BoardElement {
    private int x;
    private int y;
    private int life; 
    private int rotation; //u+d, l+r, u+l, u+r, d+l, d+r

    public SnakeSegment(int x,int y, int life, int rotation) {
        super(x, y);
        this.life = life;
        this.rotation = rotation;
        this.texturePath = "/snake/" + getRotAsStr() + ".png";
        //this.image = new ImageIcon(getClass().getResource(texturePath)).getImage();
    }

    public void subtractLife(int num) {
        life -= num;
    }

    public int getLife() {
        return life;
    }

    public String toString() {
        return "(" + x + "," + y + " " + getRotAsStr() + " " + life + ")";
    }

    public int getRotation() {
        return rotation;
    }

    //for texture
    public String getRotAsStr() {
        return Map.of(217,"ud",222,"lr",225,"ul",231,"ur",208,"dl",214,"dr").get(rotation);
    }

    //for console display
    public char getRotAsChr() {
        return Map.of(217,'|',222,'-',225,'+',231,'+',208,'+',214,'+').get(rotation);
    }
}
