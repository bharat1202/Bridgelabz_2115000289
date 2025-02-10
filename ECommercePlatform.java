
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}


interface Taxable {
    double calculateTax();
    String getTaxDetails();
}


class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }


    public double calculateDiscount() {
        return getPrice() * 0.10;
    }


    public double calculateTax() {
        return getPrice() * 0.18; 
    }

    
    public String getTaxDetails() {
        return "Tax: 18%";
    }
}


class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }


    public double calculateDiscount() {
        return getPrice() * 0.15; 
    }

   
    public double calculateTax() {
        return getPrice() * 0.05;
    }

   
    public String getTaxDetails() {
        return "Tax: 5%";
    }
}


class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05; 
    }
}
public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics(201, "Laptop", 1200),
            new Clothing(202, "Jacket", 150),
            new Groceries(203, "Apple", 2)
        };

        for (Product product : products) {
            double finalPrice = product.getPrice() - product.calculateDiscount();
            if (product instanceof Taxable) {
                finalPrice += ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            }
            product.displayDetails();
            System.out.println("Final Price: " + finalPrice);
            System.out.println("--------------------");
        }
    }
}
