package org.example;

import org.example.object.OBJ_Boots;
import org.example.object.OBJ_Door;
import org.example.object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 32 * gp.realTileSize;
        gp.obj[0].worldY = 9 * gp.realTileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 31 * gp.realTileSize;
        gp.obj[1].worldY = 14 * gp.realTileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 31 * gp.realTileSize;
        gp.obj[2].worldY = 12 * gp.realTileSize;

        gp.obj[3] = new OBJ_Boots();
        gp.obj[3].worldX = 31 * gp.realTileSize;
        gp.obj[3].worldY = 15 * gp.realTileSize;
    }
}
