import java.util.List;

public class ShippingService {
    public static void shipItems(List<ShippingItem> items) {
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0;
        for (ShippingItem item : items) {
            System.out.println("- " + item.getName() + " " + item.getWeight() + "g");
            totalWeight += (item.getWeight() /1000);
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}