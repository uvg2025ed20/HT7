package org.example;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {
    private BSTNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(E data) {
        root = insertRec(root, data);
    }

    private BSTNode<E> insertRec(BSTNode<E> node, E data) {
        if (node == null) {
            return new BSTNode<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    // Búsqueda por SKU
    public E search(String sku) {
        return searchRec(root, sku);
    }

    private E searchRec(BSTNode<E> node, String sku) {
        if (node == null) {
            return null;
        }
        Product p = (Product) node.data; // Casteamos a Product
        int compare = sku.compareTo(p.getSku());
        if (compare == 0) {
            return node.data;
        } else if (compare < 0) {
            return searchRec(node.left, sku);
        } else {
            return searchRec(node.right, sku);
        }
    }

    // Listar en orden ascendente por precio
    public ArrayList<E> inOrderAsc() {
        ArrayList<E> result = new ArrayList<>();
        inOrderAscRec(root, result);
        result.sort((a, b) -> Double.compare(((Product) a).getPriceCurrent(), ((Product) b).getPriceCurrent()));
        return result;
    }

    private void inOrderAscRec(BSTNode<E> node, ArrayList<E> list) {
        if (node != null) {
            inOrderAscRec(node.left, list);
            list.add(node.data);
            inOrderAscRec(node.right, list);
        }
    }

    // Listar en orden descendente por precio
    public ArrayList<E> inOrderDesc() {
        ArrayList<E> result = new ArrayList<>();
        inOrderAscRec(root, result);
        result.sort((a, b) -> Double.compare(((Product) b).getPriceCurrent(), ((Product) a).getPriceCurrent()));
        return result;
    }
}
