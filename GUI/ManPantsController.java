package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManPantsController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label descriptionLabel;

    private Clothing clothing;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Hier können Initialisierungsaktionen durchgeführt werden

        // Beispiel: Setzen der Daten für das Kleidungsstück
        if (clothing != null) {
            imageView.setImage(clothing.getImage());
            nameLabel.setText(clothing.get_product());
            priceLabel.setText(String.valueOf(clothing.get_price()));
        }
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;

        // Setze die Daten für das Kleidungsstück
        if (clothing != null) {
            imageView.setImage(clothing.getImage());
            nameLabel.setText(clothing.get_product());
            priceLabel.setText(String.valueOf(clothing.get_price()));
        }
    }


    public void openClothingDetails() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Clothing.fxml"));
            Parent root = fxmlLoader.load();

            ClothingDetailsController controller = fxmlLoader.getController();
            controller.setClothing(clothing);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
