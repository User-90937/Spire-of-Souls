package org.example.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int speed;
    public int worldX, worldY;
    public String direction;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public int spriteNum = 1;
    public int spriteCounter;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
}
