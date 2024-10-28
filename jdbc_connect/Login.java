package com.mycompany.test.jdbc_connect;

import java.sql.*;
import java.util.Scanner;

public class Login {

    public Books[] Books;
    private Users users;
    private Books[] books;

    public Login() {
    }

    public int login(String username, String password) {
        String Url = "jdbc:mysql://localhost:3306/smartlibrary";
        String Username = "root";
        String Password = "123456";

        try (Connection connection = DriverManager.getConnection(Url, Username, Password); Statement statement = connection.createStatement()) {
            users = getUser(connection, username, password);
            if(users == null) {
                System.out.println("Invalid username or password. Try again!");
                return 0;
            }
            System.out.println("Login successful!");
            return users.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Users getUser(Connection connection, String username, String password) throws SQLException {
        String sql = "SELECT * FROM smartlibrary.users WHERE users_name=? AND pass=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Users(
                            resultSet.getInt("users_id"),
                            resultSet.getString("users_name"),
                            resultSet.getString("pass"),
                            resultSet.getString("email")
                    );
                }
            }
        }
        return null;
    }
}