package GUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ShoppingCart {
    private HashSet<Clothing> clothings;

    public ShoppingCart() {
        clothings = new HashSet<>();
    }

    public void addItem(Clothing clothing) {
        clothings.add(clothing);
    }

    public void removeItem(Clothing clothing) {
        clothings.remove(clothing);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Clothing item : clothings) {
            total += item.get_price();
        }
        return total;
    }

    public void displayItems() {
        System.out.println("Clothing in shopping cart:");
        for (Clothing item : clothings) {
            System.out.println(item.get_product() + " - $" + item.get_price());
        }
    }
}

