package com.gmail.timurworkspace.service;

import java.util.List;

public interface AbstractService<T> {
    void saveObject(T t);
    T getById(int id);
    void deleteObject(T t);
    List<T> getAll();
}
