import java.util.ArrayList;
import java.util.List;

class Cart {
    private final double  SHIPPING_RATE = 10.0 ;
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product p, int quantity) {
        if (quantity <= p.quantity) {
            items.add(new CartItem(p, quantity));
            System.out.println(p.name + " added to the cart " + quantity);
        } else {
            System.out.println("Not available quantity , the available is " + p.quantity);
        }
    }

    public void printCart() {
        System.out.println("Product of Cart ");
        for (CartItem item : items) {
            item.printItem();
        }
    }
    List<ShippingItem> itemsToShip = new ArrayList<>();


    public void checkout(Customer customer) {
        if (items.isEmpty()) {
            System.out.println(" Cart is empty");
            return;
        }

        double subtotal = 0;
        double shippingFees = 0;

        double total = 0;
        for (CartItem item : items) {
            Product p = item.getProduct();

            if (p instanceof ExpiryProduct) {
                ExpiryProduct x = (ExpiryProduct) p;
                if (x.isExpired()) {
                    System.out.println("Product expired: " + p.name);
                    return;
                }

            }

            subtotal += item.getTotalPrice();

            if (p instanceof ShippingItem) {
                ShippingItem shippable = (ShippingItem) p;
                shippingFees += (shippable.getWeight()/1000) * SHIPPING_RATE;
                itemsToShip.add(shippable);
            }
            total = subtotal + shippingFees;
            if (customer.getBalance() < total) {
                System.out.println("Insufficient balance " + total + " Available: " + customer.getBalance());
                return;
            }

            customer.currentBalance(total);


        }
        if (!itemsToShip.isEmpty()) {
            ShippingService.shipItems(itemsToShip);
        }
        System.out.println("\n** Checkout receipt **");

        for (CartItem item1 : items) {
            System.out.println(item1.getQuantity() + "x " + item1.getProduct().name + " " + (item1.getProduct().price * item1.getQuantity()));
        }
        System.out.println("----------------------");

        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping Fees " + shippingFees);
        System.out.println("Total Paid " + total);
        System.out.println("Remaining Balance " + customer.getBalance());


        items.clear();
    }

}


