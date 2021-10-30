package model;

import controller.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager extends Tile {



    GamePanel gp;
    Tile[] tile;
    private Rectangle Rectangle;



    public TileManager(GamePanel gp) {

        this.gp = gp;
        tile = new Tile[10];

        setDefaultValues();
        getTileImage();
    }

    public void setDefaultValues(){

        //Posició inicial de la nau
        x0 = 0;
        x1 = 0;
        x2 = 0;
        y0 = 650;
        y1 = 0;
        y2 = 300;
        y3 = 500;
        y4 = 50;
        y5 = 600;
        y6 = 230;
        y7 = 580;
        y8 = 100;
        y9 = 325;
        speed1 = 2;
        speed2 = 3;
        speed3 = 1;
        speed4 = 4;

    }

    public void getTileImage() {

        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/pedra.png"));


        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tileUpdate() {

        x0 += speed1;
        if(x0 >= 576) {
            x0=0;
        }

        x1 += speed2;
        if(x1 >= 576) {
            x1=0;
        }

        x2 += speed3;
        if(x2 >= 576) {
            x2=0;
        }

        x3 += speed4;
        if(x3 >= 576) {
            x3=0;
        }
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(tile[0].image,x0,y0,gp.tileSize,gp.tileSize,null);

        g2.drawImage(tile[1].image,x1,y1,gp.tileSize1,gp.tileSize1,null);

        g2.drawImage(tile[2].image,x1,y2,gp.tileSize1,gp.tileSize1,null);

        g2.drawImage(tile[3].image,x2,y3,gp.tileSize1,gp.tileSize1,null);

        g2.drawImage(tile[4].image,x0,y4,gp.tileSize2,gp.tileSize2,null);

        g2.drawImage(tile[5].image,x2,y5,gp.tileSize2,gp.tileSize2,null);

        g2.drawImage(tile[6].image,x3,y6,gp.tileSize,gp.tileSize,null);

        g2.drawImage(tile[7].image,x3,y7,gp.tileSize2,gp.tileSize2,null);

        g2.drawImage(tile[8].image,x2,y8,gp.tileSize,gp.tileSize,null);

        g2.drawImage(tile[9].image,x2,y9,gp.tileSize,gp.tileSize,null);
    }
}
