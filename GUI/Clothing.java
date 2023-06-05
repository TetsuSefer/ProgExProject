package GUI;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public abstract class Clothing {

    protected int id;
    protected String product;
    protected double price;
    protected String gender;
    protected String size;
    protected String filter;

    protected String imagePath;
    protected Image image;


    public Clothing(String productName, double price, String gender, String size, String filter, String imagePath) {
        this.product = productName;
        this.price = price;
        this.gender = gender;
        this.size = size;
        this.filter = filter;
        File file = new File(imagePath);
        URI uri = file.toURI();
        String uriString = uri.toString();
        this.imagePath = uriString;
    }
    public Image getImage(){
        return image;
    }


    public String get_product() {
        return product;
    }
    public String getImagePath(){
        return imagePath;
    }
    public void setImagePath(String imagePath){
        this.imagePath=imagePath;
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
    public void showImage(){
        Stage stage = new Stage();
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);
        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    protected abstract String getCategory();

    public void saveToDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "deniz", "deniz");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO clothing (product, price, gender, category, size, filter, image) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, get_product());
            statement.setDouble(2, get_price());
            statement.setString(3, get_gender());
            statement.setString(4, getCategory());
            statement.setString(5, get_size());
            statement.setString(6, get_filter());
            statement.setString(7, getImagePath());

            statement.executeUpdate();

            System.out.println("Artikel erfolgreich in der Datenbank gespeichert!");
        } catch (SQLException e) {
            System.out.println("Fehler beim Speichern des Artikels in der Datenbank: " + e.getMessage());
        }
    }

}