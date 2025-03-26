package org.example;

import java.util.ArrayList;

public class BST {
    Node root;

    public BST() {
        root = null;
    }

    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private Node insertRec(Node node, Product product) {
        if (node == null) {
            return new Node(product);
        }
        if (product.getSku().compareTo(node.product.getSku()) < 0) {
            node.left = insertRec(node.left, product);
        } else if (product.getSku().compareTo(node.product.getSku()) > 0) {
            node.right = insertRec(node.right, product);
        }
        return node;
    }

    public Node search(String sku) {
        return searchRec(root, sku);
    }

    private Node searchRec(Node node, String sku) {
        if (node == null || sku.equals(node.product.getSku())) {
            return node;
        }
        if (sku.compareTo(node.product.getSku()) < 0) {
            return searchRec(node.left, sku);
        }
        return searchRec(node.right, sku);
    }

    public ArrayList<Product> inOrderAsc() {
        ArrayList<Product> result = new ArrayList<>();
        inOrderRec(root, result);
        result.sort((a, b) -> Double.compare(a.getPriceCurrent(), b.getPriceCurrent()));
        return result;
    }

    public ArrayList<Product> inOrderDesc() {
        ArrayList<Product> result = new ArrayList<>();
        inOrderRec(root, result);
        result.sort((a, b) -> Double.compare(b.getPriceCurrent(), a.getPriceCurrent()));
        return result;
    }

    private void inOrderRec(Node node, ArrayList<Product> list) {
        if (node != null) {
            inOrderRec(node.left, list);
            list.add(node.product);
            inOrderRec(node.right, list);
        }
    }
}