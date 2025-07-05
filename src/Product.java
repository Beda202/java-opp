import java.time.LocalDate;

public class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}
class ExpiryProduct extends Product {
    private LocalDate expiryDate;
    public ExpiryProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    public boolean isExpired(){
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Expire Date: " + expiryDate);
        System.out.println("Is Expired? " + (isExpired() ? "This product is expired" : "Not expired"));
    }}
 class ShippableProduct  extends Product implements  ShippingItem {
    private double weight;
public ShippableProduct (String name, double price, int quantity, double weight) {
    super(name, price, quantity);
    this.weight = weight;
}

     @Override
     public String getName() {
         return name;
     }

     @Override
     public double getWeight() {
         return weight;
     }
     @Override
     public void printInfo() {
    super.printInfo();
    System.out.println("Weight: " + weight);

     }

 }
class Cheese extends ExpiryProduct implements ShippingItem {
    private double weight;

    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public String getName() {
       return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Weight: " + weight );
    }
}



