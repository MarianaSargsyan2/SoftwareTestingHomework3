public class Item {
    String name;
    double price;

    public Item() {
        this.name = "";
        this.price = 0;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

}
