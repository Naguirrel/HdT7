import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVLoader {
    public static ArrayList<ProductEntry> loadProducts(String filename) {
        ArrayList<ProductEntry> products = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine(); // Leer encabezado
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (values.length > 18) {
                    String category = values[0];
                    String sku = values[6];
                    double priceRetail = parseDoubleSafe(values[9]);
                    double priceCurrent = parseDoubleSafe(values[10]);
                    String productName = values[18];

                    products.add(new ProductEntry(sku, category, priceRetail, priceCurrent, productName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private static double parseDoubleSafe(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
