package org.example.object;

import org.example.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;



    public void draw(Graphics2D g2, GamePanel gp) {

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX > gp.player.worldX - gp.player.screenX - gp.realTileSize &&
                worldX < gp.player.worldX + gp.player.screenX + gp.realTileSize &&
                worldY > gp.player.worldY - gp.player.screenY - gp.realTileSize &&
                worldY < gp.player.worldY + gp.player.screenY + gp.realTileSize) {

            g2.drawImage(image, screenX, screenY, gp.realTileSize, gp.realTileSize, null);
        }

    }
}
