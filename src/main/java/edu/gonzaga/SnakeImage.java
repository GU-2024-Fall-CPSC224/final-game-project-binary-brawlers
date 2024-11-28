package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SnakeImage {
    private Map<String, Image> textures;

    public SnakeImage() {
        textures = new HashMap<>();

        textures.put("headUp", loadImage("/snake/hu.png"));
        textures.put("headDown", loadImage("/snake/hd.png"));
        textures.put("headLeft", loadImage("/snake/hl.png"));
        textures.put("headRight", loadImage("/snake/hr.png"));

        textures.put("leftRight", loadImage("/snake/lr.png"));
        textures.put("upDown", loadImage("/snake/ud.png"));
        
        textures.put("downLeft", loadImage("/snake/dl.png"));
        textures.put("downRight", loadImage("/snake/dr.png"));
        textures.put("upLeft", loadImage("/snake/ul.png"));
        textures.put("upRight", loadImage("/snake/ur.png"));
    }

    private Image loadImage(String path) {
        return new ImageIcon(getClass().getResource(path)).getImage(); 
    }

    public Image getTexture(String key) {
        return textures.get(key);
    }
}