public class ProductEntry {
    private String sku;
    private String category;
    private double priceRetail;
    private double priceCurrent;
    private String productName;

    public ProductEntry(String sku, String category, double priceRetail, double priceCurrent, String productName) {
        this.sku = sku;
        this.category = category;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
    }

    public String getSku() { return sku; }
    public String getCategory() { return category; }
    public double getPriceRetail() { return priceRetail; }
    public double getPriceCurrent() { return priceCurrent; }
    public String getProductName() { return productName; }

    @Override
    public String toString() {
        return "SKU: " + sku +
               "\nCategory: " + category +
               "\nProduct: " + productName +
               "\nPrice Retail: " + priceRetail +
               "\nPrice Current: " + priceCurrent;
    }
}
