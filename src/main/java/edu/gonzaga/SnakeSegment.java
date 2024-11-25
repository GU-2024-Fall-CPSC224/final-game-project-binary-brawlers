package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SnakeSegment extends BoardElement {
    private int x;
    private int y;
    private int life; 
    private int rotation; //u+d, l+r, u+l, u+r, d+l, d+r
    private Image image;

    public SnakeSegment(int x,int y, int life, int rotation) {
        super(x, y);
        this.life = life;
        this.rotation = rotation;
        this.texturePath = "/snake/" + getRotAsStr() + ".png";
        this.image = new ImageIcon(getClass().getResource(texturePath)).getImage();
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
        return Map.of(217,"ud",222,"lr",225,"ul",231,"ur",208,"dl",214,"dr", //body
        100, "hu", 101, "hd", 102, "hl", 103, "hr", // head
        110, "tu", 111, "td", 112, "tl", 113, "tr").get(rotation); // tail
    }

    public Image getImage() {
        return image;
    }

    //for console display
    public char getRotAsChr() {
        return Map.of(217,'|',222,'-',225,'+',231,'+',208,'+',214,'+').get(rotation);
    }
}
