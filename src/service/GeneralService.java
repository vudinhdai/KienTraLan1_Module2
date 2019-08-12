package service;

import model.Product;

public interface GeneralService<E> {
    void show();

    void add(E e);
}