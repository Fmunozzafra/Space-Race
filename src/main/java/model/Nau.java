package model;

import controller.GamePanel;
import controller.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Nau {

    public int x, x1, y, y1, vides, puntuacio;
    public int speed;

    ArrayList<BufferedImage> score = new ArrayList<BufferedImage>(9);
    ArrayList<String> fileList = new ArrayList<String>();


    public BufferedImage nauUp, nauDown, nauLeft, nauRight, nau;
    public String direction;

    GamePanel gp;
    KeyHandler keyH;
    int index, index1, index2;

    public Nau(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getNauImage();
    }

    public void setDefaultValues(){

        //Vides
        vides = 5;

        //Score
        x1 = 0;
        y1 = 0;
        index = 0;
        index1 = -1;
        index2 = -1;
        fileList.add("/Number0.png");
        fileList.add("/Number1.png");
        fileList.add("/Number2.png");
        fileList.add("/Number3.png");
        fileList.add("/Number4.png");
        fileList.add("/Number5.png");
        fileList.add("/Number6.png");
        fileList.add("/Number7.png");
        fileList.add("/Number8.png");
        fileList.add("/Number9.png");

        //Posició inicial de la nau
        x = 260;
        y = 720;
        speed = 6;
        direction = "up";


    }



    public void getNauImage() {

        BufferedImage punts = null;

        try {

            //Carrego totes les imatges dels números dins d'un arraylist.
            for(String item:fileList) {
                punts = ImageIO.read(getClass().getResourceAsStream(item));
                score.add(punts);

            }

            nau = ImageIO.read(getClass().getResourceAsStream("/nauUp.png"));
            nauUp = ImageIO.read(getClass().getResourceAsStream("/nauUp.png"));
            nauDown = ImageIO.read(getClass().getResourceAsStream("/nauDown.png"));
            nauLeft = ImageIO.read(getClass().getResourceAsStream("/nauLeft.png"));
            nauRight = ImageIO.read(getClass().getResourceAsStream("/nauRight.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void update(){

     //Score
     if(y == 0 && index2 == -1) {

            index += 1;
            y = 720;
            puntuacio += 1;

            if(index > 9) {
                index = 1;
                index1 +=1;
                index2 = 1;
                puntuacio += 1;
            }

        }
        if(y == 0 && index2 != -1) {
            index1 +=1;
            y = 720;
            puntuacio += 1;

            if (index1 > 9) {
                index1 = 0;
                index += 1;
                puntuacio += 1;
            }
        }

        if(keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true) {

            if(keyH.upPressed == true){
                direction = "up";
                y -= speed;
            }else if(keyH.downPressed == true){
                direction = "down";
                y += speed;
            }else if(keyH.leftPressed == true){
                direction = "left";
                x -= speed;
            }else if(keyH.rightPressed == true){
                direction = "right";
                x += speed;
            }
        }
    }



    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch(direction) {
            case "up":
                image = nauUp;
                break;
            case "down":
                image = nauDown;
                break;
            case "left":
                image = nauLeft;
                break;
            case "right":
                image = nauRight;
                break;
        }
        //Nau
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

        //Score
        g2.drawImage(score.get(index), x1, y1, gp.tileSize, gp.tileSize, null);
        if (index1 >= 0) {
            g2.drawImage(score.get(index1), gp.tileSize, y1, gp.tileSize, gp.tileSize, null);
        }

        //Vides
        g2.drawImage(score.get(vides), 520, y1, gp.tileSize, gp.tileSize, null);
    }
}

