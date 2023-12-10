package com.sever0x.dbtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DBTableInMemory<T> implements DBTable<T> {

    private ConcurrentHashMap<Integer, T> items = new ConcurrentHashMap<>();

    private int index;

    private final Logger log = LoggerFactory.getLogger(DBTableInMemory.class);

    @Override
    public T insert(T item) {
        if (item == null) {
            log.error("item is null");
            throw new IllegalArgumentException("T can not be a null");
        }
        String id = String.valueOf(++index);
        items.put(Integer.valueOf(id), item);
        log.debug("T added --> {}", item);
        return item;
    }

    @Override
    public void delete(int id) throws SQLException {
        T t = items.remove(id);
        if (t == null) {
            throw new SQLException("Not exist with id : " + id);
        }
        log.debug("Removed : {}", t);
    }

    @Override
    public void delete(T item, Filter<T> filter) {
        for (Map.Entry<Integer, T> entry : items.entrySet()) {
            if (filter.accept(entry.getValue(), item)) {
                log.debug("Accepted to remove : {}", entry.getValue());
                boolean res = items.remove(entry.getKey(), entry.getValue());
                log.debug("IsRemoved : {}", res);
            }
        }
    }

    @Override
    public T update(int id, T item) {
        if (item == null) {
            log.debug("Not found. Id : {}", id);
            throw new NullPointerException("Item is null");
        }
        T o = items.get(id);
        if (o == null) {
            return null;
        }
        T res = items.put(id, item);
        log.debug("Found. Updated : {}", res);
        return res;
    }

    @Override
    public List<T> filter(String pattern, Filter<T> filter) {
        ArrayList<T> found = new ArrayList<>();
        for (T item : items.values()) {
            if (filter.accept(item, pattern)) {
                log.debug("Found : {}", item);
                found.add(item);
            }
        }
        return found;
    }

    @Override
    public List<T> findAll() {
        log.debug("findAll() values : {}", items.values());
        return new ArrayList<>(items.values());
    }

    @Override
    public T findById(int id) throws SQLException {
        T b = items.get(id);
        if (b == null) {
            log.debug("Not found : {}", id);
            throw new SQLException("Not found id = " + id);
        }
        log.debug("Found : {}", id);
        return b;
    }

    @Override
    public void clear() {
        items = new ConcurrentHashMap<>();
        index = 0;
    }

    @Override
    public int size() {
        return items.size();
    }

    @SafeVarargs
    @Override
    public final int[] insert(T... items) {
        int[] ids = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            ids[i] = (int) insert(items[i]);
        }
        return ids;
    }
}
