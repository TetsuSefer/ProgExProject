package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("PureFashion");
        stage.setScene(scene);
        stage.show();

        //String imagePath = "C:/Users/Deniz/IdeaProjects/ProgExProject/GUI/images_website_px/redjeans.png";
        //Pants pants = new Pants("Rote Hose", 99.99, "male", "XL", "Kids", imagePath);

        // Öffne das Kleidungsdetailfenster für das Hosenobjekt
        //ClothingController clothingController = fxmlLoader.getController();
        //clothingController.setClothing(pants);
        //clothingController.openClothingDetails();
    }

    public static void main(String[] args) {
        launch();
    }
}
