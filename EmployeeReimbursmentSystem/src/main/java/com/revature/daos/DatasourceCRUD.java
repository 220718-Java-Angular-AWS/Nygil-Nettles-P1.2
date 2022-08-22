package com.revature.daos;

import java.util.List;

public interface DatasourceCRUD<T> {

    void create(T t);
    T read(int id);
    List<T> readAll();
    void update(T t);
    void delete(int id);
}
