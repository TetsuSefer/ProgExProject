package GUI;

import java.awt.*;

public class Jackets extends Clothing {
    private String category = "Jackets";
    public Jackets(String productName, double price, String gender, String size, String filter, String imagePath) {
        super(productName, price, gender, size, filter, imagePath);
        saveToDatabase();
    }

    @Override
    protected String getCategory() {
        return category;
    }
}