/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test.jdbc_connect;

/**
 *
 * @author zmohammed
 */
public class Books {
    private int book_id;
    private String books_name;

    // Constructor to initialize book_id and books_name
    public Books(int book_id, String books_name) {
        this.book_id = book_id;       // Correctly initializing fields
        this.books_name = books_name;
    }

    // borrowBook method, needs to be implemented as per your logic
    public boolean borrowBook(int user_id, int book_id) {

        return false;
    }

    // Overloaded constructor to allow default values
    public Books() {
        this(0, "");
    }


    public int getId() {
        return book_id;
    }

    public void setId(int id) {
        this.book_id = id;
    }

    public String getTitle() {
        return books_name;
    }

    public void setTitle(String name) {
        this.books_name = name;
    }
}
