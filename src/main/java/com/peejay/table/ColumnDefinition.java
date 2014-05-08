package com.peejay.table;

public interface ColumnDefinition<T> {

    String getHeader();

    String getValue(T t);

}
