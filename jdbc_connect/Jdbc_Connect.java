package com.mycompany.test.jdbc_connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Jdbc_Connect {
    private String url = "jdbc:mysql://localhost:3306/smartlibrary";
    private String username = "root";
    private String password = "123456";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public Books[] getBooks() throws SQLException {
        String sql = "SELECT * FROM smartlibrary.Books";
        List<Books> booksList = new ArrayList<>();

        try (Connection connection = getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                booksList.add(new Books(
                        resultSet.getInt("book_id"),
                        resultSet.getString("books_name")
                ));
            }
        }

        return booksList.toArray(new Books[0]);
    }

    public long autoInc(int booksId, int userId, Timestamp time) throws SQLException {
        String sql = "INSERT INTO Users_books (book_id, user_id, login_time) VALUES (?, ?, ?)";
        long autoGeneratedId = -1;

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, booksId);
            pstmt.setInt(2, userId);
            pstmt.setTimestamp(3, time);

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    autoGeneratedId = generatedKeys.getLong(1);
                }
            }
        }

        return autoGeneratedId;
    }


    public boolean borrowBook(int user_id) {
        return false;
    }


    public boolean isBookBorrowed(int book_id) {
        String sql = "select user_id from users_books where book_id = ?";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, book_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}