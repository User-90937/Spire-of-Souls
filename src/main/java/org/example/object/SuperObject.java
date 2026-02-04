package org.example.object;

import org.example.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;



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
