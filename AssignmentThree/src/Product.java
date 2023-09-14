public class Product {
    String productName;
    String brand;
    double price;

    public Product(String productName, String brand, double price) {
        this.productName = productName;
        this.brand = brand;
        this.price = price;
    }

    public static void main(String[] args) {
        DLList list = new DLList();
        Product p = new Product("charger", "Anker", 3.2);
        Product b = new Product("TESTING", "Amazon Inc.", 32.11);
        Product i = new Product("lol", "Grees National", 3.2);
        Product e = new Product("b", "bb", 6323.2);
        System.out.println(list.toString());
        list.listAdd(p);
        list.listAdd(b);
        list.listAdd(i);
        list.listAdd(e);
        System.out.println(list.toString());
        list.listRemove(1);
        System.out.println(list.toString());



    }
}
