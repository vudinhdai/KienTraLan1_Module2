package repository.lmpl;

import model.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductRepositorylmpl implements ProductRepository {
    ArrayList<Product> products = new ArrayList<>();

    @Override
    public void show() {
        if (products.size() != 0) {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                String status = product.isStatus() ? "Stocking" : "Out of stock";
                System.out.println("ID: " + product.getId() + " Name: " + product.getName() + " Price: " + product.getPrice() +
                        " Status: " + status + " Description: " + product.getDescription());
            }
        } else {
            System.out.println("List product is emty");
        }
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void edit(int index, Product product) {
        if (index > products.size()) {
            System.out.println("Index > size");
        } else {
            products.get(index).setId(product.getId());
            products.get(index).setName(product.getName());
            products.get(index).setPrice(product.getPrice());
            products.get(index).setStatus(product.isStatus());
            products.get(index).setDescription(product.getDescription());
        }
    }

    @Override
    public void remove(int index) {
        if (index > products.size()) {
            System.out.println("Index > size");
        } else {
            products.remove(index);
        }
    }

    @Override
    public Product search(String name) {
        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).getName();
            if (productName.equals(name)) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public void sortUpPrice() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else {
                    if (o1.getPrice() == o2.getPrice()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    }

    @Override
    public void sortDownPrice() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                } else {
                    if (o1.getPrice() == o2.getPrice()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    }
}