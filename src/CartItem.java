public class CartItem {

        Product product;
        int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public void printItem() {
            System.out.println(product.name + " Quantity " + quantity);
        }

    public Product getProduct() {
            return product;
    }

    public double getTotalPrice() {
        return product.price * quantity;
    }

    public int getQuantity() {
            return quantity;
    }
}





