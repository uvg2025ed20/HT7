package org.example;

    /**
     * Represents a node in a binary search tree (BST) that stores a Product.
     */
    public class Node {
        Product product; // Stores a Product object instead of an int
        Node left, right;

        /**
         * Constructs a new Node with the specified Product.
         *
         * @param item the Product to be stored in this node
         */
        public Node(Product item) {
            product = item;
            left = right = null;
        }
    }