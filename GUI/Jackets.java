package GUI;

public class Jackets extends Clothing {
    private String category = "Jackets";
    public Jackets(String productName, double price, String gender, String size, String filter) {
        super(productName, price, gender, size, filter);
        saveToDatabase();
    }

    @Override
    protected String getCategory() {
        return category;
    }
}