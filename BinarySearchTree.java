/**
 * Implementación de un árbol binario de búsqueda genérico (BST).
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        E data;
        Node left, right;

        Node(E data) { this.data = data; }
    }

    private Node root;

    /**
     * Inserta un nuevo elemento en el árbol.
     */
    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, E data) {
        if (node == null) return new Node(data);
        if (data.compareTo(node.data) < 0) node.left = insertRec(node.left, data);
        else if (data.compareTo(node.data) > 0) node.right = insertRec(node.right, data);
        return node;
    }

    /**
     * Busca un elemento por su clave (en este caso SKU).
     */
    public E search(String sku) {
        return searchRec(root, sku);
    }

    private E searchRec(Node node, String sku) {
        if (node == null) return null;
        Product product = (Product) node.data;
        if (product.getSku().equals(sku)) return node.data;
        if (sku.compareTo(product.getSku()) < 0) return searchRec(node.left, sku);
        else return searchRec(node.right, sku);
    }
}
