package org.example;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int input_entry_main_portal;
        System.out.println("Library portal initialized...");

        int member_ID = 1;

        Scanner input_number = new Scanner(System.in);
        while (true) {


            int input_taken;
            Librarian librarian_obj = new Librarian();
            Library library_obj = new Library();

            System.out.println("-".repeat(15));
            System.out.println("1.   Enter as a librarian");
            System.out.println("2.   Enter as a member");
            System.out.println("3.   Exit");
            System.out.println("-".repeat(15));

            input_entry_main_portal = input_number.nextInt(); // main 1 2 3 wala loop

            if (input_entry_main_portal == 1) {
                System.out.println("-".repeat(15));
                System.out.println("1.   Register a member");
                System.out.println("2.   Remove a member");
                System.out.println("3.   Add a book");
                System.out.println("4.   Remove a book");
                System.out.println("5.   View all members along with their books and fines to be paid");
                System.out.println("6.   View all books");
                System.out.println("7.   Back");
                System.out.println("-".repeat(15));

                while (true) {
                    input_taken = input_number.nextInt();

                    if (input_taken == 1) {
                        librarian_obj.register_member(member_ID);
                        member_ID++;
                        break;
                    } else if (input_taken == 2) {
                        librarian_obj.remove_member();
                        break;

                    } else if (input_taken == 3) {
                        Scanner adding_book = new Scanner(System.in);

                        System.out.print("Enter Book ID: ");
                        int Book_ID = adding_book.nextInt();
                        adding_book.nextLine();
                        System.out.print("Enter Book Title: ");
                        String Book_title = adding_book.nextLine();
                        System.out.print("Enter Author: ");
                        String Author = adding_book.nextLine();
                        System.out.print("Enter Number of Copies: ");
                        int Copies = adding_book.nextInt();
                        boolean status = false;
                        Book book = new Book(Book_ID, Book_title, Author, Copies, status);
                        System.out.println("-".repeat(15));
                        System.out.println("Book Added Successfully!");
                        System.out.println("-".repeat(15));
                        break;


                    } else if (input_taken == 4) {
                        librarian_obj.remove_books();
                        break;
                    } else if (input_taken == 5) {
                        librarian_obj.print_books();
                        break;

                    } else if (input_taken == 6) {
                        librarian_obj.view_books();
                        break;
                    } else if (input_taken == 7) {
                        System.out.println("--- Going Back ---");
                        break;
                    } else {
                        System.out.println("-- !!!  ENTER CORRECT INPUT !!!---");
                        break;
                    }
                }
            } else if (input_entry_main_portal == 2) {

                while (true) {


                    Scanner login_credentials = new Scanner(System.in);
                    System.out.print("Name: ");
                    String Name = login_credentials.nextLine();
                    System.out.print("Phone_no: ");
                    Integer phone_no_ = login_credentials.nextInt();
                    System.out.println("Member_ID: ");
                    Integer Member_ID = login_credentials.nextInt();
                    Book default_book = new Book();
                    System.out.println("-".repeat(15));
                    Member default_member = new Member();

                    if (default_member.member_info.containsKey(Member_ID)) {
                        System.out.println("1. List Available Books");
                        System.out.println("2. List My Books");
                        System.out.println("3. Issue Book");

                        System.out.println("4. Return Book");
                        System.out.println("5. Pay Fine");
                        System.out.println("6. Back");
                        System.out.println("-".repeat(15));
                        System.out.println("Enter input: ");

                        int input_member = input_number.nextInt();
                        if (input_member == 1) {

                            int size = default_member.member_info.size();
                            System.out.println(size);
                            Book new_book_obj = new Book();
//                            boolean status = new_book_obj.get_book_status();

                            if ((size != 0) )  {
                                for (Map.Entry<Integer, Book> entry : default_book.book_info.entrySet()) {
                                    int bookId = entry.getValue().get_Book_ID();
                                    String book_title = entry.getValue().get_Book_Title();
                                    boolean status = entry.getValue().get_book_status();

                                    if (default_book.get_book_status() == true) {
                                        System.out.println("Book ID: " + bookId + ", Title: " + book_title);
                                    } else {
                                        System.out.println("book not found// book issued");
                                    }
                                }

                            } else {
                                System.out.println("Empty -- NO BOOK --");
                            }
                        } else if (input_member == 2) {
                            System.out.println("entered 2");
                            library_obj.listMyBooks(default_member);
                        } else if (input_member == 3) {
                            library_obj.issue_book(default_member);


                        } else if (input_member == 4) {
                            library_obj.return_book(default_member);
                        }
                        else if (input_member==5){

                            int fine = default_member.getFine();

                            if (fine==0){
                                System.out.println("no dues");
                            }
                            else {
                                default_member.setFine(0);
                                System.out.println("fine paid");
                            }

                            //pay fine

                        }
                        else if (input_member == 6) {
                            System.out.println("--- Going Back ---");
                            break;
                        } else {
                            System.out.println("-- !!!  ENTER CORRECT INPUT !!!---");
                            break;
                        }
                    } else {
                        System.out.println("Member Id Not found");
                        break;
                    }
                    break;
                }
            } else if (input_entry_main_portal == 3) {
                System.out.println("-".repeat(15));
                System.out.println("Thanks for visiting!");
                System.out.println("-".repeat(15));
                break;

            } else {
                System.out.println("-- !!!  ENTER CORRECT INPUT !!!---");
                System.out.println("---- ENTER THE PORTAL AGAIN/ EXIT IF YOU WISH TO ----");
                System.out.println("*".repeat(25));
                System.out.println("RELOADING ....");
                System.out.println("\n");
            }
        }
    }
}
