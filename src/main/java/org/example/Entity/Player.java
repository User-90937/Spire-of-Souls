package org.example.Entity;

import org.example.GamePanel;
import org.example.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void setDefaultValues() {
        x = 200;
        y = 200;
        speed = 4;
        size = 32;
        direction = "down";
        spriteNum = 1;
    }

    public void update() {
        if(keyH.upPressed) {
            direction = "up";
            y -= speed;
        } else if(keyH.downPressed) {
            direction = "down";
            y += speed;
        } else if(keyH.rightPressed) {
            direction = "right";
            x += speed;
        } else if(keyH.leftPressed) {
            direction = "left";
            x -= speed;
        }

        boolean isMoving;
        if(keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.upPressed) {
            isMoving = true;
        } else isMoving = false;

        spriteCounter++;
        System.out.println("Sprite Counter is " + spriteCounter);
        if(spriteCounter > 10) {
            if(spriteNum == 1 && isMoving) {
                spriteNum = 2;
            } else if(spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void getImages() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/paop/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/paop/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/paop/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/paop/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/paop/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/paop/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/paop/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/paop/boy_right_2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        getImages();

        switch (direction) {
            case "up":
                if(spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
        }

        g2.drawImage(image,x, y, size, size, null);
    }
}
