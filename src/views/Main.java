package views;

import controller.ProductController;
import model.Product;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductController productController = new ProductController();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            menu();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    productController.show();
                    break;
                }
                case 2: {
                    Product product = createProduct();
                    productController.add(product);
                    break;
                }
                case 3: {
                    System.out.print("Enter index of product: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter information of product: ");
                    Product product = createProduct();
                    productController.edit(index, product);
                    break;
                }
                case 4: {
                    System.out.print("Enter index of product: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    productController.remove(index);
                    break;
                }
                case 5: {
                    System.out.println("Enter name of product: ");
                    String name = scanner.nextLine();
                    Product product = productController.search(name);
                    if (product != null) {
                        String status = product.isStatus() ? "Stocking" : "Out of stock";
                        System.out.println("ID: " + product.getId() + " Name: " + product.getName() + " Price: " + product.getPrice() +
                                " Status: " + status + " Description: " + product.getDescription());
                    } else {
                        System.out.println("No product name " + name);
                    }
                    break;
                }
                case 6: {
                    productController.sortUpPrice();
                    break;
                }
                case 7: {
                    productController.sortDownPrice();
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("There is no option");
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("1. Show product");
        System.out.println("2. Add product");
        System.out.println("3. Edit product");
        System.out.println("4. Remove product");
        System.out.println("5. Search product");
        System.out.println("6. Sort up price");
        System.out.println("7. Sort down price");
        System.out.println("0. Exit");
    }

    public static Product createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        boolean status = true;
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        return new Product(id, name, price, status, description);
    }

    ;
}