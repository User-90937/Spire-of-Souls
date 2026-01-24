package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //a

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Spire of Souls");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.pack();

        gamePanel.startGameThread();

    }
}