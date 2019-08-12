package controller;

import model.Product;
import service.lmpl.ProductServicelmpl;

public class ProductController {
    ProductServicelmpl productService = new ProductServicelmpl();

    public void show() {
        productService.show();
    }

    public void add(Product product) {
        productService.add(product);
    }

    public void edit(int index, Product product) {
        productService.edit(index, product);
    }

    public void remove(int index) {
        productService.remove(index);
    }

    public Product search(String name) {
        return productService.search(name);
    }

    public void sortUpPrice() {
        productService.sortUpPrice();
    }

    public void sortDownPrice() {
        productService.sortDownPrice();
    }
}