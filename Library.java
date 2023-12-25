package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
    public static Map<Integer, Boolean> bookStatus = new HashMap<>();
    public static Map<Integer, String> book_info = new HashMap<>();
    public Book default_book = new Book();

    public void return_book(Member m) {
        System.out.println("Enter BOOK ID to return: ");
        Scanner enter_ID = new Scanner(System.in);
        int book_IDToCheck = enter_ID.nextInt();



        if (default_book.book_info.containsKey(book_IDToCheck)) {
            if (bookStatus.getOrDefault(book_IDToCheck, false)) {
                bookStatus.put(book_IDToCheck, false);

                // return time set kara

                Book.book_info.get(book_IDToCheck).set_return_time();

                int difference = (int)((Book.book_info.get(book_IDToCheck).get_return_time()) - (Book.book_info.get(book_IDToCheck).get_borrowed_time()))/1000;

                if(difference>10){

                    int fine = 3*(difference -10);

                    int previous_fine = m.getFine();


                    m.setFine(fine+previous_fine);

                    System.out.println(fine+previous_fine);



                    System.out.println("");
                }

                else{
                    System.out.println("book returned before 10 seconds ");
                }

                m.borrowed_books.remove(book_IDToCheck, Book.book_info.get(book_IDToCheck));
                System.out.println("Book with Book ID " + book_IDToCheck + " has been returned.");
            } else {

                //

                System.out.println("Book with Book ID " + book_IDToCheck + " is already available.");
            }
        } else {
            System.out.println("Book with Book ID " + book_IDToCheck + " does not exist in book_info.");
        }
    }

    public void issue_book(Member m) {
        Scanner enter_ID = new Scanner(System.in);
        System.out.println("Enter BOOK ID : ");
        int book_IDToCheck = enter_ID.nextInt();

        Book book_stat = new Book();

        boolean status = book_stat.get_book_status();

        enter_ID.nextLine();

        if (Book.book_info.containsKey(book_IDToCheck)) {
            if (bookStatus.getOrDefault(book_IDToCheck, true)) {
                bookStatus.put(book_IDToCheck, true);

                // borrow time set

                Book.book_info.get(book_IDToCheck).set_borrowed_time();



                m.borrowed_books.put(book_IDToCheck, Book.book_info.get(book_IDToCheck));
                System.out.println("Book with Book ID " + book_IDToCheck + " has been issued.");
            } else {
                System.out.println("Book with Book ID " + book_IDToCheck + " is already issued.");
            }
        } else {
            System.out.println("Book with Book ID " + book_IDToCheck + " does not exist in book_info.");
        }



    }

    public void listMyBooks(Member member) {
        for (Map.Entry<Integer, Book> entry : member.borrowed_books.entrySet()) {
            int bookId = entry.getValue().get_Book_ID();
            String book_title = entry.getValue().get_Book_Title();
            System.out.println("Book ID: " + bookId);
            System.out.println("Title: " + book_title);
            System.out.println();
        }
    }

    public void print_books() {
        System.out.println("Available Books:");
        for (Map.Entry<Integer, Boolean> entry : bookStatus.entrySet()) {
            if (entry.getValue()) {
                System.out.println("Book ID: " + entry.getKey());
            }
        }
    }
}

