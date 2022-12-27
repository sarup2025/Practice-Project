package com.oasis;

import java.util.Random;
import java.util.Scanner;

public class Numbergussing {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int randomNum = rand.nextInt(100)+1;
//        System.out.println("Random number: "+randomNum);
        int trycount = 0;
        while (true) {
            System.out.println("Guess The Number Between 1 to 100 : ");
            int inpGuess = in.nextInt();
            trycount++;
            if (inpGuess == randomNum) {
                System.out.println("Correct !!. You Win");
                System.out.println("Wow! You took "+trycount+" Attemts.");
                break;
            } else if (randomNum > inpGuess) {
                System.out.println("The number is higher . Try Again");
            } else {
                System.out.println("The number is Lower. Try Again");
            }
        }
        in.close();
    }
}
