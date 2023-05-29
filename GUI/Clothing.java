package GUI;

public class Clothing {
    protected String product;
    protected double price;
    protected String gender;
    protected String category;

    public Clothing(String Product, Double Price, String Gender, String Category) {
        this.product = Product;
        this.price = Price;
        this.gender = Gender;
        this.category = Category;
    }

    public Clothing() {
    }

    public double get_price() {
        return this.price;
    }

    public void set_price(Double Price) {
        this.price = Price;
    }

    public void set_gender(String Gender) {
        this.gender = Gender;
    }

    public String get_gender() {
        return this.gender;
    }

    public void set_category(String Category) {
        this.category = Category;
    }

    public String get_category() {
        return this.category;
    }

    public void set_product(String Product) {
        this.product = Product;
    }

    public String get_product() {
        return this.product;
    }
}
