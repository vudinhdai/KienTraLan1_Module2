package service.lmpl;

import model.Product;
import repository.lmpl.ProductRepositorylmpl;
import service.ProductService;

public class ProductServicelmpl implements ProductService {
    ProductRepositorylmpl productRepository = new ProductRepositorylmpl();

    @Override
    public void show() {
        productRepository.show();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void edit(int index, Product product) {
        productRepository.edit(index, product);
    }

    @Override
    public void remove(int index) {
        productRepository.remove(index);
    }

    @Override
    public Product search(String name) {
        return productRepository.search(name);
    }

    @Override
    public void sortUpPrice() {
        productRepository.sortUpPrice();
    }

    @Override
    public void sortDownPrice() {
        productRepository.sortDownPrice();
    }

}