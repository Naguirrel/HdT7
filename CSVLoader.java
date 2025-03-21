import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVLoader {
    public static void loadProducts(String filename, BinarySearchTree<Product> tree) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Leer encabezado
            String header = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // Maneja comas dentro de comillas
                if (values.length > 18) {
                    String sku = values[6];
                    String brand = values[8];
                    String productName = values[18];
                    double price;
                    try {
                        price = Double.parseDouble(values[10]);
                    } catch (NumberFormatException e) {
                        price = 0.0; // Por si hay precios vacíos o mal formateados
                    }
                    tree.insert(new Product(sku, brand + " - " + productName, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
