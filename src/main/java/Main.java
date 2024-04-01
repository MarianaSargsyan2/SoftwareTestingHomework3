public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item phoneCase = new Item("Phone case", 2.15);
        Item dress = new Item("Dress", 8.6);
        Item blouse = new Item("Blouse", 17.19);
        Item bag = new Item ("Bag", 10.75);
        Item sunglasses = new Item("Sunglasses", 5.37);
        Item sneakers = new Item("Sneakers", 40.83);
        cart.addItem(phoneCase);
        cart.addItem(dress);
        cart.addItem(bag);
        cart.printCart();
        cart.removeItem(dress);
        cart.printCart();
        //System.out.println(cart.getTotalPrice());
        //System.out.println(cart.getNumberOfItems());
        cart.addItem(sunglasses);
        cart.addItem(blouse);
        //System.out.println(cart.getNumberOfItems());
        cart.clearCart();
        cart.printCart();
    }
}
