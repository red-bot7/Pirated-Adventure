package Entities;

import java.awt.Color;
import java.awt.image.BufferedImage;

import Input.KeyboardInput;
import Utilz.GameFiles;
import Utilz.Variables;

public class Player extends Entity {

    // extras...

    BufferedImage[][] allFrames;
    BufferedImage[] idle, walk, jump, fall, die;
    BufferedImage spriteSheet;
    KeyboardInput keyIn;
    GameFiles files;
    int speed = 4;
    
    // Animation
    
    int currentFrame = 0;
    int currentCycle = 0;
    int MaxDelay = 12;
    int currentDelay = 0;


    public Player(KeyboardInput keyIn, GameFiles files) {
        this.keyIn = keyIn;
        this.files = files;
        setupPlayer();
    }

    // setting up the player

    public void setupPlayer() {
        x = Variables.TILE_SIZE * 4;
        y = Variables.TILE_SIZE * 8;
        setupSpriteSheet();
    }
    
    public void setupSpriteSheet() {
        // getting the reference to the image
        spriteSheet = files.PLAYER_SPRITE;

        // Chopping.. I mean seperating the image into frames

        allFrames = new BufferedImage[6][6];
        
        for(int i=0; i<6; i++) {
            for(int j=0; j<6; j++) {
                allFrames[i][j] = spriteSheet.getSubimage(i*64, j*40, 64, 40);
            }
        }
    }

    // player's updating process

    public void update() {
        updateCoordinates();
        updateAnimationCycle();
        updateCurrentFrame();
    }

    private void updateCurrentFrame() { // updating frames
        if(currentCycle == Variables.RUN) {
            if(currentFrame >= 5) {
                currentFrame = 0;
            } else {
                currentDelay++;
                if(currentDelay >= MaxDelay) {
                    currentDelay = 0;
                    currentFrame++;
                }
            }
        } else if(currentCycle == Variables.IDLE) {
            if(currentFrame >= 4) {
                currentFrame = 0;
            } else {
                currentDelay++;
                if(currentDelay >= MaxDelay) {
                    currentDelay = 0;
                    currentFrame++;
                }
            }
        }
    }

    private void updateAnimationCycle() {

        int prevCycle = currentCycle;

        if(keyIn.isMoving) {
            currentCycle = Variables.RUN;
        } else {
            currentCycle = Variables.IDLE;
        }

        if(prevCycle != currentCycle) {
            currentFrame = 0;
        }
    }

    public void updateCoordinates() {
        if(keyIn.up == true) {
            y-= speed;
        } else if(keyIn.down == true) {
            y+= speed;
        } else if(keyIn.right == true) {
            x+= speed;
        } else if(keyIn.left == true) {
            x-= speed;
        }
    }

    // player drawing

    public void draw(java.awt.Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, Variables.TILE_SIZE, Variables.TILE_SIZE);

        g.drawImage(allFrames[currentFrame][currentCycle], x - 32, y, Variables.EntityWidth, Variables.EntityHeight, null);
        
    }
}
