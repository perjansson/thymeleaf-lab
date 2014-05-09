package com.peejay.report;

public interface ColumnDefinition<T> {

    String getHeader();

    String getValue(T t);

}
