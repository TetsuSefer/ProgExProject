package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;

public abstract class Clothing {
    protected String product;
    protected double price;
    protected String gender;
    protected String size;
    protected String filter;

    public Clothing(String productName, double price, String gender, String size, String filter) {
        this.product = productName;
        this.price = price;
        this.gender = gender;
        this.size = size;
        this.filter = filter;
    }

    public String get_product() {
        return product;
    }

    public double get_price() {
        return price;
    }

    public String get_gender() {
        return gender;
    }

    public String get_size() {
        return size;
    }

    public String get_filter() {
        return filter;
    }

    protected abstract String getCategory();

    public void saveToDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "deniz", "deniz");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO clothing (product, price, gender, category, size, filter) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, get_product());
            statement.setDouble(2, get_price());
            statement.setString(3, get_gender());
            statement.setString(4, getCategory());
            statement.setString(5, get_size());
            statement.setString(6, get_filter());

            statement.executeUpdate();

            System.out.println("Artikel erfolgreich in der Datenbank gespeichert!");
        } catch (SQLException e) {
            System.out.println("Fehler beim Speichern des Artikels in der Datenbank: " + e.getMessage());
        }
    }
}