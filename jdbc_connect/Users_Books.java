/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test.jdbc_connect;

import java.sql.Timestamp;

/**
 *
 * @author zmohammed
 */
public class Users_Books {
    private int user_id;
    private int book_id;
    private Timestamp login_time;
    private int id_users_books;

    
    public int getuser_id() {
        return user_id;
    }
    public int setuser_id(){
        this.user_id = user_id;
        return 0;
    }
     public int getbook_id(){
        return book_id;
    }
    public int setbook_id(){
        this.book_id = book_id;
        return 0;
    }
     public int getuser_book_id(){
        return id_users_books;
    }
    public void setuser_book_id(){
        this.id_users_books = id_users_books;
    }

    public Timestamp getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Timestamp login_time) {
        this.login_time = login_time;
        
    }
}


