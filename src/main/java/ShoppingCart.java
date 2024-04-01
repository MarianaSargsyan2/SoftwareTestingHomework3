import java.util.ArrayList;

public class ShoppingCart {

    public ArrayList<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public ShoppingCart(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * The methods takes an item as a parameter and adds it to the cart if there are less than 10 items in the cart,
     * otherwise it gives an output "The cart is full"
     * @param item
     */
    public void addItem(Item item) {
        if(items.size() < 10) {
            items.add(item);
        } else {
            System.out.println("The cart is full");
        }

    }

    /**
     * The method takes an item as a parameter and removes that item from the cart,
     * if the item is not found the output "No such item in the cart" is given
     * @param itemToRemoved
     */
    public void removeItem(Item itemToRemoved) {
        for(Item item : items) {
            if(item.equals(itemToRemoved)) {
                items.remove(itemToRemoved);
                break;
            }
        }

    }

    /**
     * The method adds the prices of each item together and returns the total price
     * @return
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        if(items.size() == 0) {
            return totalPrice;
        }else {
            for(Item item : items) {
                totalPrice += item.getPrice();
            }
        }
        return totalPrice;
    }

    /**
     * The method returns the number of items in a cart
     * @return
     */
    public int getNumberOfItems() {
        if(items.size() == 0) {
            System.out.println("The cart is empty.");
            return 0;
        }else {
            return items.size();
        }
    }

    /**
     * The method empties the cart
     */
    public void clearCart() {
        if(items.size() == 0) {
            System.out.println("The cart is already empty");
        }else {
            items = new ArrayList<>();
        }
    }

    /**
     * helps to print the cart
     */
    public void printCart() {
        for (Item item : items) {
            System.out.println(item.getName() + ": " + item.getPrice() + "$");
        }

        System.out.println("Total: " + getTotalPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart temp = (ShoppingCart) o;
        for(int i = 0; i<= items.size() - 1; i++) {
            if(items.get(i) != temp.items.get(i)){
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}
