package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClothingDetailsController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label sizeLabel;

    private Clothing clothing;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Hier können Initialisierungsaktionen durchgeführt werden

        // Beispiel: Setzen der Daten für das Kleidungsstück
        if (clothing != null) {
            imageView.setImage(clothing.getImage());
            productNameLabel.setText(clothing.get_product());
            priceLabel.setText(String.valueOf(clothing.get_price()));
            genderLabel.setText(clothing.get_gender());
            sizeLabel.setText(clothing.get_size());
        }
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

}
