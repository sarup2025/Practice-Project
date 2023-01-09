package com.sarup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Graphics extends JPanel implements ActionListener {
    static final int WIDTH = 700;
    static final int HEIGHT = 700;

    static final String MARK_X = "X";
    static final String MARK_O = "O";

    final JButton[] tiles = new JButton[9];
    boolean isFirstPlayerActive;

    public Graphics() {
         this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
         this.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            tiles[i] = new JButton();
            tiles[i].setFont(new Font("Arial",Font.BOLD,125));
            tiles[i].setFocusable(false);
            tiles[i].addActionListener(this);
            this.add(tiles[i]);
        }
        isFirstPlayerActive = true;
    }
     @Override
    public void actionPerformed(ActionEvent e){
         for (int i = 0; i < 9; i++) {
             if (e.getSource() == tiles[i]){
                 if (tiles[i].getText().isEmpty()){
                     if (isFirstPlayerActive) {
                         tiles[i].setForeground(Color.BLACK);
                         tiles[i].setText(MARK_X);
                         isFirstPlayerActive = false;
                     } else {
                         tiles[i].setForeground(Color.BLUE);
                         tiles[i].setText(MARK_O);
                         isFirstPlayerActive = true;
                     }

                     checkState();
                 }
             }
         }
     }

     protected void checkState(){
        if (checkMark(MARK_X)){
            return;
        }

         if (checkMark(MARK_O)){
             return;
         }

         if (checkDraw()){
             return;
         }
     }

     protected boolean checkDraw(){
        int i = 0;
        while (!tiles[i].getText().isEmpty()){
            if (i == tiles.length-1){
                Arrays.stream(tiles).forEach(t -> t.setEnabled(false));
                break;
            }
            i++;
        }
        return i== tiles.length-1;
     }

    protected boolean checkMark(String mark){
        boolean isDone = false;

        //Horizontal
        isDone = checkDirection(0,1,2,mark);
        if (!isDone) isDone = checkDirection(3,4,5,mark);
        if (!isDone) isDone = checkDirection(6,7,8,mark);

        //Vertical
        if (!isDone) isDone = checkDirection(0,3,6,mark);
        if (!isDone) isDone = checkDirection(1,4,7,mark);
        if (!isDone) isDone = checkDirection(2,5,8,mark);

        //Diagonal
        if (!isDone) isDone = checkDirection(0,4,8,mark);
        if (!isDone) isDone = checkDirection(2,4,6,mark);
        return isDone;
    }
    protected boolean checkDirection(int posA,int posB,int posC,String mark){
        if (tiles[posA].getText().equals(mark) && tiles[posB].getText().equals(mark) && tiles[posC].getText().equals(mark)){
            setWinner(posA,posB,posC);
            return true;
        }
        return false;
    }

    protected void setWinner(int posA,int posB,int posC){
        tiles[posA].setBackground(Color.ORANGE);
        tiles[posB].setBackground(Color.ORANGE);
        tiles[posC].setBackground(Color.ORANGE);

        Arrays.stream(tiles).forEach(t -> t.setEnabled(false));

    }
}
