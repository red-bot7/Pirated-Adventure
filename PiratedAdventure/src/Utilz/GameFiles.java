package Utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameFiles {

    public static BufferedImage PLAYER_SPRITE;
    public static BufferedImage TERRAIN;

    public GameFiles() {
         try {
            PLAYER_SPRITE = ImageIO.read(new File("Pirated-Adventure/PiratedAdventure/res/player/PlayerSpriteSheet.png"));
            TERRAIN = ImageIO.read(new File("Pirated-Adventure/PiratedAdventure/res/PalmTreeIsland/Terrain_Sprites.png"));
         } catch (IOException e) {
            e.printStackTrace();
         }
    }

}
