package org.example;

import java.util.HashMap;
import java.util.Map;

class Book {

    public static Map<Integer, Book> book_info = new HashMap<>();

    //hashmap book
    private String Book_title;

    private long borrowed_time;

    private long return_time;
    private String Author;
    private int Book_ID;
    private int Copies;
    private boolean book_status;
    public Book(int Book_ID, String Book_title, String Author,int Copies,boolean book_status){
        this.Book_ID=Book_ID;
        this.Book_title=Book_title;
        this.Author=Author;
        this.Copies=Copies;
        this.book_status=book_status;
        book_info.put(Book_ID,this);
    }
    //defined for method 7
    // returns alll books

    public Book( ){}

    public static Map<Integer, Book> getAllBooks() { return book_info; }

    public int get_Book_ID(){ return Book_ID; }
    public String get_Book_Title(){ return Book_title; }

    public long get_borrowed_time(){ return borrowed_time; }

    public long get_return_time(){ return return_time; }

    public String get_Author() { return Author; }
    public int getTotalCopies(){
        return Copies;
    }
    public boolean get_book_status(){return book_status;}


    public void set_borrowed_time(){ this.borrowed_time=System.currentTimeMillis(); }

    public void set_return_time(){ this.return_time=System.currentTimeMillis(); }
    public void setBookId(int Book_ID){
        this.Book_ID= Book_ID;
    }

    public void setTitle(String Book_Title){
        this.Book_title= Book_title;
    }

    public void setAuthor(String Author){
        this.Author=Author;
    }

    public void setCopy(int Copies){
        this.Copies=Copies;
    }

    public static void removeBook(int bookId) {
        book_info.remove(bookId);
    }
}

