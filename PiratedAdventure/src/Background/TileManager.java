package Background;

import Utilz.GameFiles;
import Utilz.Variables;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Background.Tile;


public class TileManager {

    Tile[][] tileMap;

    public TileManager() {
         setUpTiles();
    }

    public void setUpTiles() {
        BufferedImage image = GameFiles.TERRAIN;
        tileMap = new Tile[13][4]; //[x][y] Range starts from 0

        for(int i=0; i<4; i++) {
            for(int j=0; j<12; j++) {
                tileMap[j][i] = new Tile();
                tileMap[j][i].image = image.getSubimage(32*j, 32*i, 32, 32);
            }
        }
    }

    public void draw(Graphics g) { 
        g.drawImage(tileMap[11][3].image, Variables.TILE_SIZE * 3, Variables.TILE_SIZE * 3, Variables.TILE_SIZE, Variables.TILE_SIZE, null); // max
    }

}
