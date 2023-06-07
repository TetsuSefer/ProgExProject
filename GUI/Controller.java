package GUI;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label Menu;

    @FXML
    private Label Menuback;

    @FXML
    private AnchorPane Kids_Slide;

    @FXML
    private AnchorPane Slider;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private VBox clothingContainer;

    private void slideSlider(double translateX) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), Slider);
        slide.setToX(translateX);
        slide.play();
    }
/*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Clothing> clothingList = getAllClothingFromDatabase();

        for (Clothing clothing : clothingList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Clothing.fxml"));
                VBox clothingItem = fxmlLoader.load();
                ManPantsController controller = fxmlLoader.getController();
                controller.setClothing(clothing);

                clothingContainer.getChildren().add(clothingItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
*/
public void initialize(URL url, ResourceBundle resourceBundle) {

}
    public void handleLoginButton(javafx.event.ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Account account = new Account();
        boolean loggedIn = account.login(username, password);

        if (loggedIn) {
            try {
                FXMLLoader loader = new FXMLLoader((getClass().getResource("manpants.fxml")));
                Parent root = loader.load();
                ManPantsController controller = loader.getController();
                Scene scene = new Scene(root);
                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                currentStage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Anmeldung fehlgeschlagen!");
        }
    }

    private List<Clothing> getAllClothingFromDatabase() {
        List<Clothing> clothingList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "denizdeniz");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM clothing";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("idclothing");
                String product = resultSet.getString("product");
                Double price = resultSet.getDouble("price");
                String gender = resultSet.getString("gender");
                String size = resultSet.getString("size");
                String filter = resultSet.getString("filter");
                String imagePath = resultSet.getString("image");

                // Lade das Bild aus der Datei
                Image image = new Image("file:///" + imagePath);

                // Erstelle das Kleidungsstück-Objekt mit dem geladenen Bild
                Clothing clothing = new Pants(product, price, gender, size, filter, imagePath);
                clothingList.add(clothing);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clothingList;
    }
/*/
    public void openClothingWindow(Clothing clothing) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/ClothingDetails.fxml"));
            Parent root = fxmlLoader.load();

            ClothingDetailsController clothingController = fxmlLoader.getController();
            clothingController.setClothing(clothing);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*/
}
