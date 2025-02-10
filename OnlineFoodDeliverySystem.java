
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}


class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

  
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}


class NonVegItem extends FoodItem {
    private static final double ADDITIONAL_CHARGE = 1.5;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() + ADDITIONAL_CHARGE) * getQuantity();
    }
}


public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] foodItems = {
            new VegItem("Paneer Butter Masala", 10.99, 2),
            new NonVegItem("Chicken Biryani", 15.99, 1)
        };

        for (FoodItem item : foodItems) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
        }
    }
}
