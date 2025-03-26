package org.example;

/**
 * Pablo José Vásquez Santos
 * 24757
 * Algoritmos y Estrucutras de Datos
 * Link del cual se sacó el árbol https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 */


import java.io.BufferedReader;
                    import java.io.FileReader;
                    import java.util.Scanner;

                    public class Main {

                        /**
                         * The main method that runs the application.
                         * It reads product data from a CSV file, inserts the products into a BST, and provides a menu for user interaction.
                         *
                         * @param args command-line arguments (not used)
                         */
                        public static void main(String[] args) {
                            BST bst = new BST();
                            String csvFile = "src/main/java/org/example/home appliance skus lowes.csv";

                            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                                String line;
                                br.readLine(); // Skip header line
                                int lineNumber = 1;
                                while ((line = br.readLine()) != null) {
                                    lineNumber++;
                                    String[] data = line.split(",");
                                    if (data.length < 19) {
                                        System.err.println("Línea " + lineNumber + " incompleta: " + line);
                                        continue;
                                    }

                                    try {
                                        String category = data[0];
                                        String sku = data[6];
                                        double priceRetail = data[9].isEmpty() ? 0.0 : Double.parseDouble(data[9]);
                                        double priceCurrent = data[10].isEmpty() ? 0.0 : Double.parseDouble(data[10]);
                                        String productName = data[18];

                                        Product product = new Product(sku, priceRetail, priceCurrent, productName, category);
                                        bst.insert(product);
                                    } catch (NumberFormatException e) {
                                        System.err.println("Error en línea " + lineNumber + ": precio inválido en " + line);
                                    } catch (Exception e) {
                                        System.err.println("Error en línea " + lineNumber + ": " + e.getMessage());
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            Scanner scanner = new Scanner(System.in);
                            int option;
                            do {
                                System.out.println("\nMenú de opciones:");
                                System.out.println("1. Buscar producto por SKU");
                                System.out.println("2. Mostrar productos ordenados por precio ascendente");
                                System.out.println("3. Mostrar productos ordenados por precio descendente");
                                System.out.println("4. Salir");
                                System.out.print("Seleccione una opción: ");
                                option = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                switch (option) {
                                    case 1:
                                        System.out.print("Ingrese SKU a buscar: ");
                                        String sku = scanner.nextLine();
                                        Node foundNode = bst.search(sku);
                                        if (foundNode != null) {
                                            System.out.println("Producto encontrado: " + foundNode.product);
                                        } else {
                                            System.out.println("Producto no encontrado.");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("\nProductos ordenados por precio ascendente:");
                                        for (Product p : bst.inOrderAsc()) {
                                            System.out.println(p);
                                        }
                                        break;
                                    case 3:
                                        System.out.println("\nProductos ordenados por precio descendente:");
                                        for (Product p : bst.inOrderDesc()) {
                                            System.out.println(p);
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Saliendo...");
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Intente de nuevo.");
                                }
                            } while (option != 4);

                            scanner.close();
                        }
                    }