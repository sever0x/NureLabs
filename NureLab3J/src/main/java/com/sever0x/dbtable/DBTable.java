package com.sever0x.dbtable;

import java.sql.SQLException;
import java.util.List;

public interface DBTable<T> {

    T insert(T item);

    void delete(int id) throws SQLException;

    void delete(T item, Filter<T> filter);

    T update(int id, T item);

    List<T> filter(String pattern, Filter<T> filter);

    List<T> findAll();

    T findById(int id) throws SQLException;

    void clear();

    int size();

    int[] insert(T... items);
}

