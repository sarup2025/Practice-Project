package com.codeclause;

import java.util.Scanner;

public class User {
    String userName;
    String userid;

    Book borrowedbook[] = new Book[3];
    public int booksCount = 0;
    Scanner in = new Scanner(System.in);

    public User() {
        System.out.println("Enter User Name: ");
        this.userName = in.nextLine();
        System.out.println("Enter User Id: ");
        this.userid = in.nextLine();
    }
}
