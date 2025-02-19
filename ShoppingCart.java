import java.util.*;

public class ShoppingCart {
    Map<String, Double> productPrices = new HashMap<>();
    Map<String, Double> orderedItems = new LinkedHashMap<>();
    TreeMap<Double, String> sortedByPrice = new TreeMap<>();

    public void addItem(String product, double price) {
        productPrices.put(product, price);
        orderedItems.put(product, price);
        sortedByPrice.put(price, product);
    }

    public void displayCart() {
        System.out.println("Ordered Items: " + orderedItems);
        System.out.println("Sorted Items by Price: " + sortedByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 800);
        cart.addItem("Phone", 500);
        cart.addItem("Mouse", 50);

        cart.displayCart();
    }
}
