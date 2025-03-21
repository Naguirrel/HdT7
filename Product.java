/**
 * Clase que representa un producto con SKU, nombre y precio.
 */
public class Product implements Comparable<Product> {
    private String sku;
    private String name;
    private double price;

    public Product(String sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public int compareTo(Product other) {
        return this.sku.compareTo(other.sku);
    }
}
