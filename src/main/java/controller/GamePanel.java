package controller;

import model.Nau;
import model.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel<image> extends JPanel implements Runnable{

    //Configuració de Pantalla
    final int originalTileSize = 16; //Mida 16x16
    final int originalTileSize1 = 8; //Mida 16x16
    final int originalTileSize2 = 4; //Mida 16x16
    final int scale = 3;
    final int scale1 = 2;
    final int scale2 = 1;
    public final int tileSize = originalTileSize * scale; //Mida final 48 x 48
    public final int tileSize1 = originalTileSize1 * scale1; //Mida final 48 x 48
    public final int tileSize2 = originalTileSize2 * scale2; //Mida final 48 x 48

    final int maxScreenCol = 12; //Ample de la pantalla
    final int maxSreenRow= 16; //Altura de la pantalla
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxSreenRow; //576 pixels


    //FPS
    int FPS = 60;

    Thread gameThread;

    //Tecles / Moviment
    KeyHandler keyH = new KeyHandler();

    //Genero nau
    Nau nau= new Nau(this, keyH);

    //Genero asteroides
    TileManager tile0 = new TileManager(this);
    TileManager tile1 = new TileManager(this);
    TileManager tile2 = new TileManager(this);
    TileManager tile3 = new TileManager(this);
    TileManager tile4 = new TileManager(this);
    TileManager tile5 = new TileManager(this);
    TileManager tile6 = new TileManager(this);
    TileManager tile7 = new TileManager(this);
    TileManager tile8 = new TileManager(this);
    TileManager tile9 = new TileManager(this);

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true); //Amb aixó podem rebre el input del GamePanel


    }




    @Override
    //Game loop
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.01666 segons
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread != null){

            //1 Actualitzo la posició del coet
            update();

            //2 Actualitzo la informació de la pantalla
            repaint();

            //3 Miro les colisions
            checkCollisions();

            try {
                double tempsRestant = nextDrawTime -System.nanoTime();
                tempsRestant = tempsRestant/1000000;

                if(tempsRestant < 0 ){
                    tempsRestant = 0;
                }

                Thread.sleep((long) tempsRestant);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void gameOver() {
        if (nau.puntuacio >9 ) {
            nau.puntuacio -= 1;
        }
        JOptionPane.showMessageDialog(this, "Game Over" + "\n" + "Puntuació: " + nau.puntuacio, "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public void update() {


        nau.update();
        tile0.tileUpdate();
        tile1.tileUpdate();
        tile2.tileUpdate();
        tile3.tileUpdate();
        tile4.tileUpdate();
        tile5.tileUpdate();
        tile6.tileUpdate();
        tile7.tileUpdate();
        tile8.tileUpdate();
        tile9.tileUpdate();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        nau.draw(g2);
        tile0.draw(g2);
        tile1.draw(g2);
        tile2.draw(g2);
        tile3.draw(g2);
        tile4.draw(g2);
        tile5.draw(g2);
        tile6.draw(g2);
        tile7.draw(g2);
        tile8.draw(g2);
        tile9.draw(g2);

        g2.dispose();

    }

    //Miro les colions i controlo les vides.
    public void checkCollisions(){
        if (NauPosition().intersects(tile0Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile1Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile2Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile3Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile4Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile5Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile6Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile7Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile9Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        } else if(NauPosition().intersects(tile8Position())) {
            nau.y=720;
            nau.vides -= 1;
            if (nau.vides <=0) gameOver();
        }
    }

    public Rectangle NauPosition (){
        return new Rectangle(nau.x,nau.y,tileSize,tileSize);
    }

    public Rectangle tile0Position (){
        return new Rectangle(tile0.x0,tile0.y0,tileSize,tileSize);
    }

    public Rectangle tile1Position (){
        return new Rectangle(tile1.x1,tile1.y1,tileSize1,tileSize1);
    }

    public Rectangle tile2Position (){
        return new Rectangle(tile2.x1,tile2.y2,tileSize1,tileSize1);
    }

    public Rectangle tile3Position (){
        return new Rectangle(tile3.x2,tile3.y3,tileSize1,tileSize1);
    }

    public Rectangle tile4Position (){
        return new Rectangle(tile4.x0,tile4.y4,tileSize2,tileSize2);
    }

    public Rectangle tile5Position (){
        return new Rectangle(tile5.x2,tile5.y5,tileSize2,tileSize2);
    }

    public Rectangle tile6Position (){
        return new Rectangle(tile6.x3,tile7.y6,tileSize,tileSize);
    }

    public Rectangle tile7Position (){
        return new Rectangle(tile7.x3,tile7.y7,tileSize2,tileSize2);
    }

    public Rectangle tile8Position (){
        return new Rectangle(tile8.x2,tile8.y8,tileSize,tileSize);
    }

    public Rectangle tile9Position (){
        return new Rectangle(tile9.x2,tile9.y9,tileSize,tileSize);
    }
}
