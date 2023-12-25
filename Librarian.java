package org.example;

import java.util.Scanner;

public class Librarian {

    public int input_taken;

    public int input_entry_main_portal;

    public void view_books() {
        int count = 0;
        for (Book book : Book.getAllBooks().values()) {
            count += 1;
            System.out.println(count);
            System.out.println("Book ID: " + book.get_Book_ID());
            System.out.println("Title: " + book.get_Book_Title());
            System.out.println("Author: " + book.get_Author());
            System.out.println("Total Copies: " + book.getTotalCopies());
            System.out.println();
        }
    }

    public void remove_books() {
        Scanner adding_book = new Scanner(System.in);

        System.out.print("Enter Book ID : ");
        int Book_ID = adding_book.nextInt();

        Book.removeBook(Book_ID); // This will remove the book with ID 1 from the map

    }


    public void register_member(int member_ID) {
        Scanner member_ID_input = new Scanner(System.in);

        System.out.print("Name: ");
        String Member_Name = member_ID_input.nextLine();

        System.out.print("Age: ");
        int Age = member_ID_input.nextInt();

        member_ID_input.nextLine();

        System.out.print("Phone no: ");
        String Phone_no = member_ID_input.nextLine();

        boolean memberExists = false;
        for (Member existingMember : Member.member_info.values()) {
            if (existingMember.getPhoneNo().equals(Phone_no)) {
                memberExists = true;
                break;
            }
        }

        if (memberExists) {
            System.out.println("A member with the same phone no already exists.");
        } else {
            Member member = new Member(Member_Name, Age, Phone_no,member_ID);

            System.out.println("-".repeat(15));
            System.out.println("Member Successfully Registered with Member ID: " + member.member_ID());
        }

    }

    public void print_books() {
        if (Member.member_info.isEmpty()) {
            System.out.println("No members found.");
            //  call kaha karna

        } else {

            for (Member member : Member.member_info.values()) {

                System.out.println("Member ID: " + member.member_ID());
                System.out.println("Name: " + member.getName());
                System.out.println("Age: " + member.getAge());
                System.out.println("Phone No: " + member.getPhoneNo());
                System.out.println("Fine " + member.getFine());
                System.out.println();

            }
        }
    }

    public void remove_member() {
        Scanner member_obj = new Scanner(System.in);

        System.out.print("Enter Member ID : ");
        int member_ID = member_obj.nextInt();
        if (Member.member_info.containsKey(member_ID)) {
            Member.member_info.remove(member_ID);
            System.out.println("Member with ID " + member_ID + " has been removed.");
        } else {
            System.out.println("Member with ID " + member_ID + " not found.");
        }

    }
}





