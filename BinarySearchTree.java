public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
        E data;
        Node left, right;
        Node(E item) { data = item; }
    }

    private Node root;

    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, E data) {
        if (root == null) return new Node(data);
        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);
        return root;
    }

    public E search(E data) {
        Node node = searchRec(root, data);
        return node != null ? node.data : null;
    }

    private Node searchRec(Node root, E data) {
        if (root == null || root.data.equals(data)) return root;
        if (data.compareTo(root.data) < 0)
            return searchRec(root.left, data);
        return searchRec(root.right, data);
    }
}
