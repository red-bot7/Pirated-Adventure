package Utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameFiles {

    public static BufferedImage PLAYER_SPRITE;
    public static BufferedImage TERRAIN;
    public static BufferedImage LEVEL_TEST;

    public GameFiles() {
         try {
            // General

            PLAYER_SPRITE = ImageIO.read(new File("Pirated-Adventure/PiratedAdventure/res/player/PlayerSpriteSheet.png"));
            TERRAIN = ImageIO.read(new File("Pirated-Adventure/PiratedAdventure/res/PalmTreeIsland/Terrain_Sprites.png"));
            // Levels

            LEVEL_TEST = ImageIO.read(new File("Pirated-Adventure/PiratedAdventure/res/Levels/Test.png"));
         
         } catch (IOException e) {
            e.printStackTrace();
         }
    }

}
