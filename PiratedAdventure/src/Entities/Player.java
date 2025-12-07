package Entities;

import java.awt.Color;
import java.awt.image.BufferedImage;
import Utilz.Variables;

public class Player extends Entity {

    BufferedImage[][] allFrames;
    BufferedImage[] idle, walk, jump, fall, die;
    BufferedImage spriteSheet;


    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x +=1;
        y +=1;
    }

    public void draw(java.awt.Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, Variables.TILE_SIZE, Variables.TILE_SIZE);
    }
}
