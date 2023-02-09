package com.codeclause;

import java.util.Scanner;

public class Book {
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQuty;
    public int bookQutyCopy;

    Scanner in = new Scanner(System.in);

    public Book() {
        System.out.println("Enter the Serial Numbers of Books: ");
        this.sNo = in.nextInt();
        in.nextLine();
        System.out.println("Enter the Book Name: ");
        this.bookName = in.nextLine();
        System.out.println("Enter the Author Name: ");
        this.authorName = in.nextLine();
        System.out.println("Enter the Quantity of Books: ");
        this.bookQuty = in.nextInt();
        bookQutyCopy = this.bookQuty;
    }
}
