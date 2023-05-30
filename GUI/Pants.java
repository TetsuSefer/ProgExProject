package GUI;

public class Pants extends Clothing {
    private String category = "Pants";
    public Pants(String productName, double price, String gender, String size, String filter) {
        super(productName, price, gender, size, filter);
        saveToDatabase();
    }

    @Override
    protected String getCategory() {
        return category;
    }
}