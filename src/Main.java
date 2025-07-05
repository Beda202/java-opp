import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        Product p1 = new Product("Mobile scratch ", 200.0, 1);
        Product p2 = new ShippableProduct("TV", 4000.0, 2, 20000);
        Product p3 = new ExpiryProduct("SoftwareLicence ", 1000.0, 10, LocalDate.now().plusMonths(5) );
        Product p4 = new Cheese( "Biscuits", 20, 10, LocalDate.of(2025,7,10),400) ;

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        for (Product p : products) {
            System.out.println(" Product Details");
            p.printInfo();

            if (p instanceof ShippingItem ) {
                ShippingItem shippable = (ShippingItem) p;
            System.out.println("Shipping: Yes");
            System.out.println("Weight: " + shippable.getWeight()/1000 + " kg");
        } else {
            System.out.println("Shipping: No");
        }

    }
        Customer customer = new Customer("Ali", 70000);
        Cart cart = new Cart();
        cart.addProduct(p1, 2);
        cart.addProduct(p2, 1);
        cart.addProduct(p3, 1);
        cart.addProduct(p4, 1);

        cart.checkout(customer);

    }}