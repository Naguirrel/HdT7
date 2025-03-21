import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal para cargar el árbol y buscar productos por SKU.
 */
public class Main {
    public static void main(String[] args) {
        // Cargar productos del CSV
        ArrayList<Product> products = CSVLoader.loadProducts("productos.csv");

        // Crear el árbol binario
        BinarySearchTree<Product> bst = new BinarySearchTree<>();
        for (Product p : products) {
            bst.insert(p);
        }

        // Iniciar el scanner para recibir input del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Buscador de productos por SKU ===");

        while (true) {
            System.out.print("\nIngrese el SKU que desea buscar (o escriba 'salir' para terminar): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("salir")) break;

            Product result = bst.search(input);
            if (result != null) {
                System.out.println("Producto encontrado:");
                System.out.println("SKU: " + result.getSku());
                System.out.println("Nombre: " + result.getName());
                System.out.println("Precio: $" + result.getPrice());
            } else {
                System.out.println("Producto con SKU " + input + " no encontrado.");
            }
        }

        scanner.close();
        System.out.println("¡Gracias por usar el sistema!");
    }
}
