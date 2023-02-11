package com.oasis;

import java.util.Scanner;

public class Atm_interface {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double balance = 0;
        double withdraw,deposit;
        while (true){
            System.out.println("============================================ ATM INTERFCE MADE BY SARUP===================================================================");
            System.out.println("Your Available BAlance is: "+"₹"+balance);
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check balance");
            System.out.println("Choose 4 for Exit");
            System.out.println("Choose the Operation You Want");
            System.out.println("==========================================================================================================================================");
            int choice = in.nextInt();
            switch (choice){
                case 1->{
                    System.out.println("Enter The Amount to Withdraw");
                    withdraw = in.nextInt();
                    balance = balance - withdraw;
                    if (balance>=withdraw){
                        System.out.println("Collect Your Money");
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                }
                case 2 ->{
                    System.out.println("Enter The Amount to Deposit");
                    deposit = in.nextInt();
                    balance = balance + deposit;
                    System.out.println("Successfully Depositted");
                }
                case 3->{
                    System.out.println("Available Balance: "+"₹ "+ balance);
                    System.out.println();
                }
                case 4->{
                    System.exit(0);
                }
            }
        }
    }
}
