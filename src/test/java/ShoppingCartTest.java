import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartTest {

    @Test
    public void testAddItemBelowCapacity() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);

        // Act
        cart.addItem(item1);

        // Assert
        assertEquals(1, cart.getNumberOfItems(), "The number of items in the cart should become 1");
        assertTrue(cart.items.contains(item1), "item1 should be added to the cart");
    }

    @Test
    public void testAddItemAtCapacity() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        for(int i = 1; i <= 10; i++) {
            cart.addItem(item1);
        }

        Item item2 = new Item("dress", 18.22);

        // Act
        cart.addItem(item2);

        // Assert
        assertEquals(10, cart.getNumberOfItems(), "Cart should remain at the same capacity");
        assertFalse(cart.items.contains(item2), "Item2 should not be added to the cart");
    }


    @Test
    public void testRemoveExistingItem() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        Item item2 = new Item("dress", 18.22);
        cart.addItem(item1);
        cart.addItem(item2);

        // Act
        cart.removeItem(item1);

        // Assert
        assertFalse(cart.items.contains(item1), "The cart should not contain the removed item.");
        assertEquals(1, cart.getNumberOfItems(), "The items in the cart should be one less than before removing.");
    }

    @Test
    public void testRemoveNonExistingItem() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        Item item2 = new Item("dress", 18.22);
        cart.addItem(item1);

        // Act
        cart.removeItem(item2);

        // Assert
        assertTrue(cart.items.contains(item1), "The cart should contain already present items");
        assertEquals(1, cart.getNumberOfItems(), "Cart should still have 1 item");
    }

    @Test
    public void testRemoveFromEmptyCart() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);

        // Act
        cart.removeItem(item1);

        // Assert
        assertEquals(0, cart.getNumberOfItems(), "Cart should remain empty");
    }

    @Test
    public void testGetTotalPriceEmptyCart() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Act
        double totalPrice = cart.getTotalPrice();

        // Assert
        assertEquals(0, totalPrice, "Total price should be 0 for empty cart");
    }

    @Test
    public void testGetTotalPriceSingleItem() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        cart.addItem(item1);

        // Act
        double totalPrice = cart.getTotalPrice();

        // Assert
        assertEquals(cart.items.get(0).price, totalPrice, "Total price should be the item's price");
    }

    @Test
    public void testGetTotalPriceMultipleItems() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        Item item2 = new Item("dress", 18.22);
        Item item3 = new Item("dress", 26.8);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        // Act
        double totalPrice = cart.getTotalPrice();

        // Assert
        assertEquals(11.79 + 18.22 + 26.8, totalPrice, "Total price should be sum of item prices");
    }

    @Test
    public void testGetNumberOfItemsEmptyCart() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Act
        int numItems = cart.getNumberOfItems();

        // Assert
        assertEquals(0, numItems, "Number of items should be 0 for empty cart");
    }

    @Test
    public void testGetNumberOfItemsSingleItem() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        cart.addItem(item1);

        // Act
        int numItems = cart.getNumberOfItems();

        // Assert
        assertEquals(1, numItems, "Number of items should be 1");
    }

    @Test
    public void testGetNumberOfItemsMultipleItems() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        Item item2 = new Item("dress", 18.22);
        Item item3 = new Item("dress", 26.8);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        // Act
        int numItems = cart.getNumberOfItems();

        // Assert
        assertEquals(3, numItems, "Number of items should be 2");
    }

    @Test
    public void testGetNumberOfItemsAfterRemoval() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        Item item2 = new Item("dress", 18.22);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.removeItem(item1);

        // Act
        int numItems = cart.getNumberOfItems();

        // Assert
        assertEquals(1, numItems, "Number of items should be 1 after removal");
    }

    @Test
    public void testClearCartEmptyCart() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Act
        cart.clearCart();

        // Assert
        assertEquals(0, cart.getNumberOfItems(), "Cart should remain empty after clearing");
    }

    @Test
    public void testClearCartSingleItems() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        cart.addItem(item1);


        // Act
        cart.clearCart();

        // Assert
        assertEquals(0, cart.getNumberOfItems(), "Cart should be empty after clearing");
    }
    
    @Test
    public void testClearCartMultipleItem() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("shirt", 11.79);
        Item item2 = new Item("dress", 18.22);
        Item item3 = new Item("dress", 26.8);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        // Act
        cart.clearCart();

        // Assert
        assertEquals(0, cart.getNumberOfItems(), "Cart should be empty after clearing");
    }

}