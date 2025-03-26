package org.example;

        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.*;

        import java.util.ArrayList;

        public class BSTTest {

            /**
             * Tests inserting a product into the BST and searching for it by SKU.
             * Verifies that the product can be found and the SKU matches.
             */
            @Test
            void insertAndSearchProduct() {
                BST bst = new BST();
                Product product = new Product("123", 100.0, 90.0, "Test Product", "Category");
                bst.insert(product);
                Node result = bst.search("123");
                assertNotNull(result);
                assertEquals("123", result.product.getSku());
            }

            /**
             * Tests searching for a non-existent product in the BST.
             * Verifies that the search returns null.
             */
            @Test
            void searchNonExistentProduct() {
                BST bst = new BST();
                Product product = new Product("123", 100.0, 90.0, "Test Product", "Category");
                bst.insert(product);
                Node result = bst.search("999");
                assertNull(result);
            }

            /**
             * Tests the inOrderAsc method to ensure it returns products sorted by price in ascending order.
             * Verifies the order of products in the result.
             */
            @Test
            void inOrderAscReturnsProductsSortedByPrice() {
                BST bst = new BST();
                bst.insert(new Product("123", 100.0, 90.0, "Product A", "Category"));
                bst.insert(new Product("124", 200.0, 150.0, "Product B", "Category"));
                bst.insert(new Product("125", 300.0, 250.0, "Product C", "Category"));

                ArrayList<Product> result = bst.inOrderAsc();
                assertEquals(3, result.size());
                assertEquals("Product A", result.get(0).getProductName());
                assertEquals("Product B", result.get(1).getProductName());
                assertEquals("Product C", result.get(2).getProductName());
            }

            /**
             * Tests the inOrderDesc method to ensure it returns products sorted by price in descending order.
             * Verifies the order of products in the result.
             */
            @Test
            void inOrderDescReturnsProductsSortedByPrice() {
                BST bst = new BST();
                bst.insert(new Product("123", 100.0, 90.0, "Product A", "Category"));
                bst.insert(new Product("124", 200.0, 150.0, "Product B", "Category"));
                bst.insert(new Product("125", 300.0, 250.0, "Product C", "Category"));

                ArrayList<Product> result = bst.inOrderDesc();
                assertEquals(3, result.size());
                assertEquals("Product C", result.get(0).getProductName());
                assertEquals("Product B", result.get(1).getProductName());
                assertEquals("Product A", result.get(2).getProductName());
            }

            /**
             * Tests inserting a duplicate product into the BST.
             * Verifies that the product can still be found and the SKU matches.
             */
            @Test
            void insertDuplicateProduct() {
                BST bst = new BST();
                Product product = new Product("123", 100.0, 90.0, "Test Product", "Category");
                bst.insert(product);
                bst.insert(product);
                Node result = bst.search("123");
                assertNotNull(result);
                assertEquals("123", result.product.getSku());
            }
        }