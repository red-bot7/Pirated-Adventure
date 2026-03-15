package Background;

import Utilz.GameFiles;
import Utilz.Variables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TileManager {

    Tile[][] tileMap;
    Boolean[][] tileMapCollision;
    int [][] LevelTileIndexRow = new int[45][14]; // [column][row]
    int [][] LevelTileIndexColumn = new int[45][14]; // [column][row]

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

    public boolean checkBlockCollidable(int x, int y) {
        int xIndex = LevelTileIndexRow[x][y];
        int yIndex = LevelTileIndexColumn[x][y];

        return tileMapCollision[yIndex][xIndex];
    }

    public void loadMap(Graphics g, int indexOffset) {
        for(int i=0; i<14; i++) { // row
            for(int j=0; j<45; j++) { // col
                int pixel = GameFiles.LEVEL_TEST.getRGB(j, i);
                
                Color color = new Color(pixel);

                int xIndex = color.getRed();
                int yIndex = color.getGreen();

                LevelTileIndexRow[j][i] = xIndex;
                LevelTileIndexColumn[j][i] = yIndex;
                
                draw(g, xIndex, yIndex, j, i, indexOffset);
            }
        }
    }



    public void draw(Graphics g, int xIndex, int yIndex, int xMapLocation, int yMapLocation, int drawOffset) { 
        g.drawImage(tileMap[yIndex][xIndex].image, Variables.TILE_SIZE * xMapLocation - drawOffset, Variables.TILE_SIZE * yMapLocation, Variables.TILE_SIZE, Variables.TILE_SIZE, null); // max
    }

}
