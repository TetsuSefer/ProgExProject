package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("root", "denizdeniz");
        account.registration("tami", "tami", "tami@tami.tami");
        String imagePath = "C:/Users/Deniz/IdeaProjects/ProgExProject/GUI/Zeichnung.png";
        Pants pant = new Pants("Rote Hose", 99.99, "male", "XL", "Kids", imagePath);
        // Jackets jacket = new Jackets("Gucci Jacke", 299.99, "female", "S", "Women");

    }


    //          String imagePath = pant.getImagePath();
    //        Image image = new Image("Zeichnung.Png" + pant.getImagePath());

    public static void showAll(String filter2) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "deniz", "deniz");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Clothing WHERE filter = ?");
        ) {
            statement.setString(1, filter2);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String productName = resultSet.getString("product");
                double price = resultSet.getDouble("price");
                String gender = resultSet.getString("gender");
                String category = resultSet.getString("category");
                String size = resultSet.getString("size");
                String filter = resultSet.getString("filter");

                System.out.println("Product: " + productName);
                System.out.println("Price: " + price);
                System.out.println("Gender: " + gender);
                System.out.println("Category: " + category);
                System.out.println("Size: " + size);
                System.out.println("Filter: " + filter);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Ausführen der Datenbankabfrage: " + e.getMessage());
        }
    }
}
