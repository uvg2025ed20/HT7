package org.example;

    import java.util.ArrayList;
    import java.util.Comparator;

    /**
     * Represents a Binary Search Tree (BST) that stores Product objects.
     */
    public class BST {
        Node root;

        /**
         * Constructs an empty BST.
         */
        public BST() {
            root = null;
        }

        /**
         * Inserts a product into the BST.
         *
         * @param product the product to be inserted
         */
        public void insert(Product product) {
            root = insertRec(root, product);
        }

        /**
         * Recursively inserts a product into the BST.
         *
         * @param node the current node
         * @param product the product to be inserted
         * @return the updated node
         */
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

        /**
         * Searches for a product by SKU in the BST.
         *
         * @param sku the SKU of the product to search for
         * @return the node containing the product, or null if not found
         */
        public Node search(String sku) {
            return searchRec(root, sku);
        }

        /**
         * Recursively searches for a product by SKU in the BST.
         *
         * @param node the current node
         * @param sku the SKU of the product to search for
         * @return the node containing the product, or null if not found
         */
        private Node searchRec(Node node, String sku) {
            if (node == null || sku.equals(node.product.getSku())) {
                return node;
            }
            if (sku.compareTo(node.product.getSku()) < 0) {
                return searchRec(node.left, sku);
            }
            return searchRec(node.right, sku);
        }

        /**
         * Returns a list of products sorted by current price in ascending order.
         *
         * @return a list of products sorted by current price in ascending order
         */
        public ArrayList<Product> inOrderAsc() {
            ArrayList<Product> result = new ArrayList<>();
            inOrderRec(root, result);
            result.sort(Comparator.comparingDouble(Product::getPriceCurrent));
            return result;
        }

        /**
         * Returns a list of products sorted by current price in descending order.
         *
         * @return a list of products sorted by current price in descending order
         */
        public ArrayList<Product> inOrderDesc() {
            ArrayList<Product> result = new ArrayList<>();
            inOrderRec(root, result);
            result.sort((a, b) -> Double.compare(b.getPriceCurrent(), a.getPriceCurrent()));
            return result;
        }

        /**
         * Recursively performs an in-order traversal of the BST and adds products to the list.
         *
         * @param node the current node
         * @param list the list to add products to
         */
        private void inOrderRec(Node node, ArrayList<Product> list) {
            if (node != null) {
                inOrderRec(node.left, list);
                list.add(node.product);
                inOrderRec(node.right, list);
            }
        }
    }