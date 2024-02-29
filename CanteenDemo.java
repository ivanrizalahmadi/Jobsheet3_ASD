public class CanteenDemo {
    public static void main(String[] args) {
        Item item1 = new Item();
        item1.name = "Nasi goreng";
        item1.price = 15000;
        item1.stock = 10;

        Item item2 = new Item();
        item2.name = "Donat gula";
        item2.price = 3000;
        item2.stock = 20;

        Item item3 = new Item();
        item3.name = "Cimory";
        item3.price = 7000;
        item3.stock = 15;

        System.out.println("Item 1:");
        System.out.println("Name: " + item1.name);
        System.out.println("Price: " + item1.price);
        System.out.println("Stock: " + item1.stock);

        System.out.println("\nItem 2:");
        System.out.println("Name: " + item2.name);
        System.out.println("Price: " + item2.price);
        System.out.println("Stock: " + item2.stock);

        System.out.println("\nItem 3:");
        System.out.println("Name: " + item3.name);
        System.out.println("Price: " + item3.price);
        System.out.println("Stock: " + item3.stock);
    }
}
