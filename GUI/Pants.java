package GUI;

public class Pants extends Clothing {
    private String category = "Pants";
    public Pants(String productName, double price, String gender, String size, String filter, String imagePath) {
        super(productName, price, gender, size, filter, imagePath);
    }

    @Override
    protected String getCategory() {
        return category;
    }
}