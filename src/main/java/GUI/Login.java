package GUI;

import java.sql.*;

public class Login extends Account {
    public static void main(String[] args) {
        String username = "your_username";
        String password = "your_password";

        Login login = new Login();
        boolean isLoggedIn = login.login(username, password);

        if (isLoggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }

    public boolean login(String username, String password) {
        try (Connection connection = DriverManager.getConnection(url, this.username, this.password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE username = ? AND password = ?")) {

            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // Returns true if there is a matching record, false otherwise
        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
            return false;
        }
    }
}
