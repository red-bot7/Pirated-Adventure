package Background;

import Utilz.GameFiles;
import Utilz.Variables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TileManager {

    Tile[][] tileMap;
    Boolean[][] tileMapCollision;
    int [][] LevelTileIndexRow = new int[12][4]; // [column][row]

    public TileManager() {
        setUpTiles(); // [And Colision]
    }

    public void setUpTiles() {
        BufferedImage image = GameFiles.TERRAIN;
        tileMap = new Tile[12][4]; // [column][row]
        tileMapCollision = new Boolean[12][4];

        for(int i=0; i<4; i++) {
            for(int j=0; j<12; j++) {
                tileMap[j][i] = new Tile();
                tileMap[j][i].image = image.getSubimage(32*j, 32*i, 32, 32);

                // collision property :)
                
                if(i==0 && j == 11) {
                    tileMapCollision[j][i] = false;
                } else {
                    tileMapCollision[j][i] = true;
                }
            }
        }

        // water tiles (Later part)
    }

    public void loadMap(Graphics g) {
        for(int i=0; i<14; i++) { // row
            for(int j=0; j<45; j++) { // col
                int pixel = GameFiles.LEVEL_TEST.getRGB(j, i);
                
                Color color = new Color(pixel);

                int xIndex = color.getRed();
                int yIndex = color.getGreen();
                
                draw(g, xIndex, yIndex, j, i);
            }
        }
    }



    public void draw(Graphics g, int xIndex, int yIndex, int xMapLocation, int yMapLocation) { 
        g.drawImage(tileMap[yIndex][xIndex].image, Variables.TILE_SIZE * xMapLocation, Variables.TILE_SIZE * yMapLocation, Variables.TILE_SIZE, Variables.TILE_SIZE, null); // max
    }

}
