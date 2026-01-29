package org.example.tile;

import org.example.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    Tile[] tile;
    GamePanel gp;
    int mapTileNum[][];
    int worldCol = 50;
    int worldRow = 50;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[5];
        mapTileNum = new int[worldCol][worldRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass00.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass00.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadMap() {

        InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int col = 0;
        int row = 0;

        while (col < worldCol && row < worldRow) {

            try {
                String line = br.readLine();
                System.out.println(line);

                while (col < worldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == worldCol) {
                    col = 0;
                    row++;
                }

            } catch (Exception e) {

            }
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawTile(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < worldCol && row < worldRow) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.realTileSize, gp.realTileSize, null);
            col++;
            x += gp.realTileSize;

            if(col == worldCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.realTileSize;
            }
        }
    }
}
