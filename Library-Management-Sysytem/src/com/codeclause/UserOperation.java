package com.codeclause;

import java.util.Scanner;

public class UserOperation {
    Scanner in = new Scanner(System.in);
    User theusers[] = new User[50];

    public static int count = 0;

    // add users
    public void addUsers(User u){
        for (int i = 0; i < count; i++) {
            if (u.userid.equalsIgnoreCase(theusers[i].userid)){
                System.out.println("User of User Id "+u.userid+" is Already Exist");
                return;
            }
        }
        if (count<=50){
            theusers[count] = u;
            count++;
        }
    }

    // displace all users
    public void displayUsers(){
        System.out.println("User Name\t\tUser Id");
        for (int i = 0; i < count; i++) {
            System.out.println(theusers[i].userName+"\t\t"+theusers[i].userid);
        }
    }

    // check the users
    public int checkUsers(){
        System.out.println("Enter the User Id: ");
        String useid = in.nextLine();
        for (int i = 0; i < count; i++) {
            if (theusers[i].userid.equalsIgnoreCase(useid)){
                return i;
            }
        }
        System.out.println("User Is Not Registerd");
        System.out.println("Kindly Register Yourself");
        return -1;
    }

    // remove book
    public void checkOutBook(BookOperation Book){
        int userIndex = this.checkUsers();
        if (userIndex!=-1){
            System.out.println("Checking Out");
            Book.DisplayBooks();
            Book b = Book.checkoutBook();
            System.out.println("Checking Out");
            if (b!=null){
                if (theusers[userIndex].booksCount<=3){
                    System.out.println("Adding Book");
                    theusers[userIndex].booksCount++;
                    return;
                }
                else {
                    System.out.println("User Can Not Borrow More Than 3 Books.");
                    return;
                }
            }
            System.out.println("Currently The Book Is Not Available.");
        }
    }

    // to add the book
    public void checkinBook(BookOperation Book){
        int userIndex = this.checkUsers();
        if (userIndex!=-1){
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
            User u = theusers[userIndex];
            for (int i = 0; i < u.booksCount; i++) {
                System.out.println(u.borrowedbook[i].sNo+"\t\t\t"+u.borrowedbook[i].bookName+"\t\t\t"+u.borrowedbook[i].authorName);
            }
            System.out.println("Enter The Serial Number of Book to Be Checked In. ");
            int sNo = in.nextInt();
            for (int i = 0; i < u.booksCount; i++) {
                if (sNo==u.borrowedbook[i].sNo){
                    Book.checkInBook(u.borrowedbook[i]);
                    u.borrowedbook = null;

                    return;
                }
            }
            System.out.println("Book of Serial Number "+sNo+" not found");
        }
    }
}
