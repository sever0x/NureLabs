package com.sever0x.dbtable;

public interface Filter<T> {
    <K> boolean accept(T item, K pattern);
}
