package com.sarup;

import javax.swing.*;

public class Game extends JFrame {
    public Game(){
        this.add(new  Graphics());
        this.setTitle("===============Tic Tac Toe Using Java=====================");
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
