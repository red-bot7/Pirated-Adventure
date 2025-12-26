package Utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameFiles {

    public BufferedImage PLAYER_SPRITE;

    public GameFiles() {
         try {
            PLAYER_SPRITE = ImageIO.read(new File("Pirated-Adventure/PiratedAdventure/res/player/PlayerSpriteSheet.png"));
         } catch (IOException e) {
            e.printStackTrace();
         }
    }

}
