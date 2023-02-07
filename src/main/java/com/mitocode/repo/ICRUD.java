package com.mitocode.repo;

import java.util.List;

public interface ICRUD <T, ID>{

    List<T> findAll();

    T findById(T t);

    T save(T t);

    void update(T t);

    void delete(T t);
}