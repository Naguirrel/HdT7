import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase para cargar datos desde un archivo CSV.
 */
public class CSVLoader {
    /**
     * Carga los productos del archivo CSV y los devuelve en una lista.
     */
    public static ArrayList<Product> loadProducts(String filename) {
        ArrayList<Product> products = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String sku = values[6];
                String name = values[18];
                double price = Double.parseDouble(values[10]);
                products.add(new Product(sku, name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
