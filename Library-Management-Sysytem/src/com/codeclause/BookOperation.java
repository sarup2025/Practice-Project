package com.codeclause;

import java.util.Scanner;

public class BookOperation {
    Book theBookList[] = new Book[50];
    public static int count;

    Scanner in = new Scanner(System.in);

    // check the books
    public int checkBooks(Book b1, Book b2) {
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
            System.out.println("This Book is Already Exist.");
            return 0;
        }
        if (b1.sNo == b2.sNo) {
            System.out.println("This Serial Number is used");
            return 0;
        }
        return 1;
    }

    // add the books
    public void addBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (this.checkBooks(b, this.theBookList[i]) == 0)
                return;
        }
        if (count < 50) {
            theBookList[count] = b;
            count++;
        } else {
            System.out.println("No More Space to add New Books");
        }
    }

    // search the books by sno
    public void SearchBookbySno() {
        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
        int sNo;
        System.out.println("Enter The Serial Number of Book:");
        sNo = in.nextInt();
        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvaiable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            if (sNo == theBookList[i].sNo) {
                System.out.println(theBookList[i].sNo + " \t\t" + theBookList[i].bookName + "\t\t" + theBookList[i].authorName + "\t\t" + theBookList[i].bookQutyCopy + "\t\t" + theBookList[i].bookQuty);
                flag++;
                return;
            }
        }
        if (flag == 0) {
            System.out.println("There is No Book for Serial Number: " + sNo);
        }
    }

    // search books by author
    public void SearchBooksByauthor() {
        System.out.println("\t\t\t\tSEARCH BY AUTHOR NAME\n");
        in.nextLine();
        System.out.println("Enter the Author Name: ");
        String authorName = in.nextLine();
        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvaiable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            if (authorName.equalsIgnoreCase(theBookList[i].authorName)) {
                System.out.println(theBookList[i].sNo + " \t\t" + theBookList[i].bookName + "\t\t" + theBookList[i].authorName + "\t\t" + theBookList[i].bookQutyCopy + "\t\t" + theBookList[i].bookQuty);
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("There is No Books Of: " + authorName);
        }
    }

    // show the books
    public void DisplayBooks() {
        System.out.println("\t\t\t\tDISPLAYING ALL THER BOOKS");
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvaiable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            System.out.println(theBookList[i].sNo + " \t\t" + theBookList[i].bookName + "\t\t" + theBookList[i].authorName + "\t\t" + theBookList[i].bookQutyCopy + "\t\t" + theBookList[i].bookQuty);
        }
    }

    // edit the books
    public void updateBookQty() {
        System.out.println("\t\t\t\tUPDATE THE QUANTITY OF A BOOK\n");
        System.out.println("Enter The Serial Number of Book");
        int sNo;
        sNo = in.nextInt();
        for (int i = 0; i < count; i++) {
            if (sNo == theBookList[i].sNo) {
                System.out.println("Enter the Number of Books to Be Added: ");
                int addingQty = in.nextInt();
                theBookList[i].bookQuty += addingQty;
                theBookList[i].bookQutyCopy += addingQty;

                return;
            }
        }
    }

    // create menu
    public void creatMenu() {
        System.out.println("===========================================================================================================");
        System.out.println("Press 1 to Add New Book.");
        System.out.println("Press 0 to Exit the Application.");
        System.out.println("Press 2 to Upgrade the Quantity Of Books.");
        System.out.println("Press 3 to  Search Books.");
        System.out.println("Press 4 to Show All Books");
        System.out.println("Press 5 to Register Users");
        System.out.println("Press 6 to Display All Users.");
        System.out.println("Press 7 to Check Out Book");
        System.out.println("Press 8 to Check In Book");
        System.out.println("=============================================================================================================");
    }

    //to search the books is available or not
    public int isAvailable(int sNo) {
        for (int i = 0; i < count; i++) {
            if (sNo == theBookList[i].sNo) {
                if (theBookList[i].bookQutyCopy > 0) {
                    System.out.println("The Book Is Available.");
                    return i;
                }
                System.out.println("The Book Is Currently Unavailable.");
                return -1;
            }
        }
        System.out.println("No Book Of Serial Number "+" Avavilable in Library");
        return -1;
    }

    // to remove books
    public Book checkoutBook(){
        System.out.println("Enter the Serial No of Book You want to be Checked Out");
        int sNo = in.nextInt();
        int bookIndex = isAvailable(sNo);
        if (bookIndex != -1){
            theBookList[bookIndex].bookQutyCopy--;
            return theBookList[bookIndex];
        }
        return null;
    }

    // add books to library
    public void checkInBook(Book b){
        for (int i = 0; i < count; i++) {
            if (b.equals(theBookList[i])){
                theBookList[i].bookQutyCopy++;
                return;
            }

        }
    }
}
