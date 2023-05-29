package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jackets extends Clothing {
    public Jackets(String Product, Double Price, String Gender, String Category) {
        super.product = Product;
        super.price = Price;
        super.gender = Gender;
        super.category = Category;
        saveToDatabase();
    }
    public void saveToDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "deniz", "deniz");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO jackets (product, price, gender, category) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, get_product());
            statement.setDouble(2, get_price());
            statement.setString(3, get_gender());
            statement.setString(4, get_category());
            statement.executeUpdate();

            System.out.println("Jackets saved to database successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving Jackets to database: " + e.getMessage());
        }
    }

    public void deleteFromDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "deniz", "deniz");
             PreparedStatement statement = connection.prepareStatement("DELETE FROM jackets WHERE product = ?")) {

            statement.setString(1, get_product());
            statement.executeUpdate();

            System.out.println("Pants deleted from database successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting Pants from database: " + e.getMessage());
        }
    }
}
