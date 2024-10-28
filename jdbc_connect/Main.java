package com.mycompany.test.jdbc_connect;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Jdbc_Connect jdbcConnect = new Jdbc_Connect();
        Login login = new Login();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int users_id = login.login(username,
                password);
        if (users_id == 0) {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        Books[] books = jdbcConnect.getBooks();
        System.out.println("Available books:");
        for (Books book : books) {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Book Name: " + book.getTitle());
        }

        while (true) {
            System.out.print("Enter the book ID you want to borrow: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            // Check if the book is already borrowed
            if (jdbcConnect.isBookBorrowed(bookId)) {
                System.out.println("Invalid book ID. Book is already borrowed. Please choose another book.");
            } else {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                int user_id = 0;
                long autoGeneratedId = jdbcConnect.autoInc(bookId, user_id, timestamp);
                System.out.println("Auto-generated ID: " + autoGeneratedId);
                break;
            }
        }
    }
}