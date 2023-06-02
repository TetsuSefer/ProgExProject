package GUI;

import java.sql.*;

public class Registration {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "denizdeniz";

    public void addAccount(String username, String password) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (username, password) VALUES (?, ?)")) {

            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();

            System.out.println("Account created successfully!");
        } catch (SQLException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    public void printAllAccounts() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving accounts: " + e.getMessage());
        }
    }

}
