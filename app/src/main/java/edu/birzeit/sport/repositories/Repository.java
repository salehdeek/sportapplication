package edu.birzeit.sport.repositories;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(int id);

    T save(T t);

    void deleteById(int id);

}
