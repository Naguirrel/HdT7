import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<ProductEntry> products = CSVLoader.loadProducts("productos.csv");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el SKU que desea buscar: ");
        String inputSku = scanner.nextLine();

        List<ProductEntry> matches = products.stream()
                .filter(p -> p.getSku().equals(inputSku))
                .collect(Collectors.toList());

        if (matches.isEmpty()) {
            System.out.println("No se encontraron productos con el SKU: " + inputSku);
        } else {
            ProductEntry lowest = matches.stream()
                    .min((p1, p2) -> Double.compare(p1.getPriceCurrent(), p2.getPriceCurrent()))
                    .get();

            System.out.println("\nProducto con el precio más bajo:");
            System.out.println(lowest);
        }
    }
}
