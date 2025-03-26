package org.example;

        /**
         * Represents a product with SKU, retail price, current price, product name, and category.
         * Implements Comparable to allow sorting by SKU.
         */
        public class Product implements Comparable<Product> {
            private String sku;
            private double priceRetail;
            private double priceCurrent;
            private String productName;
            private String category;

            /**
             * Constructs a new Product with the specified details.
             *
             * @param sku the SKU of the product
             * @param priceRetail the retail price of the product
             * @param priceCurrent the current price of the product
             * @param productName the name of the product
             * @param category the category of the product
             */
            public Product(String sku, double priceRetail, double priceCurrent, String productName, String category) {
                this.sku = sku;
                this.priceRetail = priceRetail;
                this.priceCurrent = priceCurrent;
                this.productName = productName;
                this.category = category;
            }

            /**
             * Returns the SKU of the product.
             *
             * @return the SKU of the product
             */
            public String getSku() { return sku; }

            /**
             * Returns the retail price of the product.
             *
             * @return the retail price of the product
             */
            public double getPriceRetail() { return priceRetail; }

            /**
             * Returns the current price of the product.
             *
             * @return the current price of the product
             */
            public double getPriceCurrent() { return priceCurrent; }

            /**
             * Returns the name of the product.
             *
             * @return the name of the product
             */
            public String getProductName() { return productName; }

            /**
             * Returns the category of the product.
             *
             * @return the category of the product
             */
            public String getCategory() { return category; }

            /**
             * Compares this product to another product by SKU.
             *
             * @param other the other product to compare to
             * @return a negative integer, zero, or a positive integer as this SKU is less than, equal to, or greater than the specified SKU
             */
            @Override
            public int compareTo(Product other) {
                return this.sku.compareTo(other.sku);
            }

            /**
             * Returns a string representation of the product.
             *
             * @return a string representation of the product
             */
            @Override
            public String toString() {
                return "SKU: " + sku + ", Product: " + productName + ", Category: " + category +
                        ", Retail Price: " + priceRetail + ", Current Price: " + priceCurrent;
            }
        }