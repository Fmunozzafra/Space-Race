package mvcgui;

import controller.GamePanel;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.*;

public class Main {

    JFrame window = new JFrame();
    Container con;
    JPanel titleNamePanel, startButtonPanel;
    JLabel titleNameLabel;
    JButton startButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(white);
        window.setTitle("Space Race - Menu");
        window.setVisible(true);
        window.setLayout(null);

        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(white);
        titleNameLabel = new JLabel("SPACE RACE");
        titleNameLabel.setForeground(black);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 600, 200, 100);
        startButtonPanel.setBackground(white);

        startButton = new JButton("START");
        startButton.setBackground(black);
        startButton.setForeground(white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        startButtonPanel.setLocation(300 ,300);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

    }

    public void createGameScreen() {

            JFrame joc = new JFrame();

            titleNamePanel.setVisible(false);
            startButtonPanel.setVisible(false);
            window.setVisible(false);

            joc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            joc.setResizable(false);
            joc.setTitle("Space Race");

            GamePanel gamePanel = new GamePanel();
            joc.add(gamePanel);
            joc.pack(); //Obliga a la window a tindre la mida del Gamepanel.
            joc.setLocationRelativeTo(null);
            joc.setVisible(true);

            gamePanel.startGameThread();
        }

        public class TitleScreenHandler implements ActionListener {
            public void actionPerformed(ActionEvent actionEvent) {
                createGameScreen();
            }
        }
    }

