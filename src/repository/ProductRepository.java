package repository;

import model.Product;

public interface ProductRepository extends GeneralRepository<Product> {
    void edit(int index , Product product);
    void remove(int name);
    Product search(String name);
    void sortUpPrice();
    void sortDownPrice();
}
