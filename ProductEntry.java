/**
 * Clase que representa una entrada de producto en el sistema.
 * Contiene información como SKU, precio actual, precio de lista,
 * nombre del producto y la categoría.
 */
public class ProductEntry implements Comparable<ProductEntry> {
    private String sku;
    private double priceCurrent;
    private double priceRetail;
    private String productName;
    private String category;

    /**
     * Constructor de ProductEntry
     * @param sku Código SKU del producto
     * @param priceCurrent Precio actual del producto
     * @param priceRetail Precio de lista o de venta al público
     * @param productName Nombre del producto
     * @param category Categoría del producto
     */
    public ProductEntry(String sku, double priceCurrent, double priceRetail, String productName, String category) {
        this.sku = sku;
        this.priceCurrent = priceCurrent;
        this.priceRetail = priceRetail;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    public String getSku() { return sku; }
    public double getPriceCurrent() { return priceCurrent; }
    public double getPriceRetail() { return priceRetail; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    /**
     * Implementación del método compareTo basado en el SKU
     * @param other Otro producto a comparar
     * @return resultado de la comparación de los SKU
     */
    @Override
    public int compareTo(ProductEntry other) {
        return this.sku.compareTo(other.sku);
    }

    /**
     * Devuelve una representación en String del producto
     * @return Detalles del producto en texto
     */
    @Override
    public String toString() {
        return "SKU: " + sku + 
               "\nPrecio Actual: $" + priceCurrent + 
               "\nPrecio Retail: $" + priceRetail + 
               "\nNombre: " + productName + 
               "\nCategoría: " + category;
    }
}