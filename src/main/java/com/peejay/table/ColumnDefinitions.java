package com.peejay.table;

import java.util.ArrayList;
import java.util.List;

public abstract class ColumnDefinitions<T> {

    private List<ColumnDefinition<T>> columns = new ArrayList<ColumnDefinition<T>>();

    public void addColumn(ColumnDefinition<T> column) {
        columns.add(column);
    }

    public List<ColumnDefinition<T>> getColumns() {
        return columns;
    }

}
