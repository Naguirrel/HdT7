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

    @Override
    public int compareTo(Product other) {
        return this.sku.compareTo(other.sku);
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Name: " + name + ", Price: " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product other) {
            return this.sku.equals(other.sku);
        }
        return false;
    }
}
