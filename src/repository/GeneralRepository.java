package repository;

public interface GeneralRepository<E> {
    void show();

    void add(E e);
}