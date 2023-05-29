package GUI;

import java.sql.*;

public class Pants extends Clothing {
    private int idPants;
    public Pants(String product, double price, String gender, String category) {
        super(product, price, gender, category);
        saveToDatabase();
    }



    public void saveToDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "deniz", "deniz");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Pants (product, price, gender, category) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, get_product());
            statement.setDouble(2, get_price());
            statement.setString(3, get_gender());
            statement.setString(4, get_category());
            statement.executeUpdate();

            System.out.println("Pants saved to database successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving Pants to database: " + e.getMessage());
        }
    }

    public void deleteFromDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "deniz", "deniz");
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Pants WHERE product = ?")) {

            statement.setString(1, get_product());
            statement.executeUpdate();

            System.out.println("Pants deleted from database successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting Pants from database: " + e.getMessage());
        }
    }
}

