package com.peejay.table;

import java.util.List;

public class Table<T> {

    private List<T> data;
    private ColumnDefinitions<T> columnDefinitions;

    public Table(List<T> data, ColumnDefinitions<T> columnDefinitions) {
        this.data = data;
        this.columnDefinitions = columnDefinitions;
    }

    public List<T> getData() {
        return data;
    }

    public ColumnDefinitions<T> getColumnDefinitions() {
        return columnDefinitions;
    }
}
