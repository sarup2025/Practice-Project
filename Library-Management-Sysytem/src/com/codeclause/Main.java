package com.codeclause;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("=========================WELCOME=============================");
        System.out.println("            SELECT THE OPTIONS      ");
        System.out.println("=======================================================");
        BookOperation obj = new BookOperation();
        UserOperation obUser = new UserOperation();

        int choice;
        int seacrhChoice;
        do {
            obj.creatMenu();
            choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    Book b = new Book();
                    obj.addBook(b);
                }
                case 2 -> obj.updateBookQty();
                case 3 -> {
                    System.out.println("Press 1 to Search Book With Serial Number. ");
                    System.out.println("Press 2 to Search Book With Author Name.");
                    seacrhChoice = in.nextInt();
                    switch (seacrhChoice) {
                        case 1 -> obj.SearchBookbySno();
                        case 2 -> obj.SearchBooksByauthor();
                    }
                }
                case 4 -> obj.DisplayBooks();
                case 5 -> {
                    User u = new User();
                    obUser.addUsers(u);
                }
                case 6 -> obUser.displayUsers();
                case 7 -> obUser.checkOutBook(obj);
                case 8 -> obUser.checkinBook(obj);
                default -> System.out.println("ENTER BETWEEN 0 to 8");
            }
        }
        while (choice!=0);
    }
}
