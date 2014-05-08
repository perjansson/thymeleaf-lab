package com.peejay.table;

import java.util.List;

public class Table<T> {

    private List<T> rows;
    private ColumnDefinitions<T> columns;

    public Table(List<T> rows, ColumnDefinitions<T> columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public List<T> getRows() {
        return rows;
    }

    public ColumnDefinitions<T> getColumns() {
        return columns;
    }
}
