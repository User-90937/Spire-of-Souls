package org.example.tile;

import org.example.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    Tile[] tile;
    GamePanel gp;
    Tile[][] tiles;

public TileManager(GamePanel gp) {
    this.gp = gp;

    tile = new Tile[5];
    tiles = new Tile[gp.maxScreenCol][gp.maxScreenRow];
    getTileImage();
}

public void getTileImage() {
    try {
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass00.png"));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

public void drawTile(Graphics2D g2) {
    int col = 0;
    int row = 0;
    int x = 0;
    int y = 0;

    while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
        for(int i = 0; i < gp.maxScreenCol; i++) {
            g2.drawImage(tile[0].image, x, y, gp.realTileSize, gp.realTileSize, null);
            x += gp.realTileSize;
        }
        col++;
        x = 0;
        y += gp.realTileSize;
        row++;
    }

}
}
