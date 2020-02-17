package com.gmail.timurworkspace.dao;

import java.util.List;

public interface AbstractDao<T> {
    void saveObject(T t);
    T getById(int id);
    void deleteObject(T t);
    List<T> getAll();
}
