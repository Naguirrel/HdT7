public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Product> tree = new BinarySearchTree<>();
        CSVLoader.loadProducts("productos.csv", tree);

        Product searchProduct = new Product("SKU002", "", 0);
        Product result = tree.search(searchProduct);
        if (result != null) {
            System.out.println("Producto encontrado: " + result);
        } else {
            System.out.println("Producto NO encontrado");
        }
    }
}
