class BinaryTree<E extends Comparable<E>> {
    E element;
    BinaryTree<E> leftChild;
    BinaryTree<E> rightChild;

    /**
     * Constructor de la clase BinaryTree.
     * @param element El elemento almacenado en el nodo.
     */
    public BinaryTree(E element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinarySearchTree<E extends Comparable<E>> {
    private BinaryTree<E> root;

    /**
     * Constructor de la clase BinarySearchTree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Método para insertar un elemento en el árbol binario de búsqueda.
     * @param element El elemento a insertar.
     */
    public void insert(E element) {
        root = insertRec(root, element);
    }

    /**
     * Método privado para insertar un elemento de forma recursiva en el árbol.
     * @param node El nodo raíz del subárbol.
     * @param element El elemento a insertar.
     * @return El nodo raíz actualizado después de la inserción.
     */
    private BinaryTree<E> insertRec(BinaryTree<E> node, E element) {
        if (node == null) {
            node = new BinaryTree<>(element);
            return node;
        }

        if (element.compareTo(node.element) < 0) {
            node.leftChild = insertRec(node.leftChild, element);
        } else if (element.compareTo(node.element) > 0) {
            node.rightChild = insertRec(node.rightChild, element);
        }

        return node;
    }

    /**
     * Método para buscar un elemento en el árbol binario de búsqueda.
     * @param element El elemento a buscar.
     * @return El elemento encontrado, o null si no está presente en el árbol.
     */
    public E search(E element) {
        return searchRec(root, element);
    }

    /**
     * Método privado para buscar un elemento de forma recursiva en el árbol.
     * @param node El nodo raíz del subárbol.
     * @param element El elemento a buscar.
     * @return El elemento encontrado, o null si no está presente en el árbol.
     */
    private E searchRec(BinaryTree<E> node, E element) {
        if (node == null || node.element.equals(element)) {
            return (node != null) ? node.element : null;
        }

        if (element.compareTo(node.element) < 0) {
            return searchRec(node.leftChild, element);
        } else {
            return searchRec(node.rightChild, element);
        }
    }

    /**
     * Método para realizar un recorrido in-order en el árbol binario.
     */
    public void inorderTraversal() {
        inorderTraversalRec(root);
    }

    /**
     * Método privado para realizar un recorrido in-order de forma recursiva en el árbol.
     * @param node El nodo raíz del subárbol.
     */
    private void inorderTraversalRec(BinaryTree<E> node) {
        if (node != null) {
            inorderTraversalRec(node.leftChild);
            System.out.print(node.element + " ");
            inorderTraversalRec(node.rightChild);
        }
    }
}
