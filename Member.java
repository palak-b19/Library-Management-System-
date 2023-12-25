package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Member {



        public static Map<Integer, Book> borrowed_books = new HashMap<>();


        // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


        private String name;
        private int Age;
        private String Phone_No;

        private int member_ID=1;

        private int fine;

        public static int member_ID_count = 1;
        public static Map<Integer, Member> member_info = new HashMap<>();


        public Member(String name, int Age, String Phone_No,int member_ID) {
            this.name = name;
            this.Age = Age;
            this.Phone_No = Phone_No;
            this.member_ID=member_ID;
//        this.fine=fine;
//        int member_ID = member_ID_count;
//        member_ID_count++;
            member_info.put(member_ID, this);
        }

        public int getFine() {
            return fine;

        }

        public Member(){}

        public int member_ID() {
            return this.member_ID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return Age;
        }

        public void setFine(int fine) { this.fine=fine; }

        public void setAge(int age) {
            this.Age = Age;
        }

        public String getPhoneNo() {
            return Phone_No;
        }

        public void setPhoneNo(String Phone_No) {
            this.Phone_No = Phone_No;
        }

    }


