package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Product> bst = new BinarySearchTree<>();
        String csvFile = "src/main/java/org/example/home appliance skus lowes.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine();
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Listar productos por precio ascendente");
            System.out.println("3. Listar productos por precio descendente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.print("Ingrese SKU a buscar: ");
                    String sku = scanner.nextLine();
                    Product found = bst.search(sku);
                    if (found != null) {
                        System.out.println("Producto encontrado: " + found);
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
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}