package com.peejay.report;

import java.util.List;

public class Table<T> {

    private List<T> rows;
    private ColumnDefinitions<T> columnDefinitions;

    public Table(List<T> rows, ColumnDefinitions<T> columnDefinitions) {
        this.rows = rows;
        this.columnDefinitions = columnDefinitions;
    }

    public List<T> getRows() {
        return rows;
    }

    public List<ColumnDefinition<T>> getColumns() {
        return columnDefinitions.getColumns();
    }
}
