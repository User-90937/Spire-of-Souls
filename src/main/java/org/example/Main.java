package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //a

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Spire of Souls");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        gamePanel.startGameThread();

    }
}