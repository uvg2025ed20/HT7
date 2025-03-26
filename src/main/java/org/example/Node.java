package org.example;

public class Node {
    Product product; // Almacena un objeto Product en lugar de un int
    Node left, right;

    public Node(Product item) {
        product = item;
        left = right = null;
    }
}