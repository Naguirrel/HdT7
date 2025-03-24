import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Product> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void testInsertSingleProduct() {
        Product p = new Product("SKU123", "Licuadora", 99.99);
        bst.insert(p);
        Product result = bst.search("SKU123");
        assertNotNull(result);
        assertEquals("SKU123", result.getSku());
        assertEquals("Licuadora", result.getName());
        assertEquals(99.99, result.getPrice());
    }

    @Test
    public void testInsertMultipleProductsAndSearch() {
        Product p1 = new Product("A100", "Microondas", 150.0);
        Product p2 = new Product("B200", "Refrigerador", 899.0);
        Product p3 = new Product("C300", "Licuadora", 89.0);

        bst.insert(p2);
        bst.insert(p1);
        bst.insert(p3);

        Product result = bst.search("B200");
        assertNotNull(result);
        assertEquals("Refrigerador", result.getName());

        Product result2 = bst.search("C300");
        assertNotNull(result2);
        assertEquals("Licuadora", result2.getName());
    }

    @Test
    public void testSearchNonExistentSKU() {
        Product p = new Product("Z999", "Tostadora", 45.50);
        bst.insert(p);
        Product result = bst.search("X123"); // SKU no insertado
        assertNull(result);
    }

    @Test
    public void testSearchInEmptyTree() {
        Product result = bst.search("NADA");
        assertNull(result);
    }
}