package com.peejay.report.module;

import com.peejay.report.Module;
import com.peejay.table.*;

import java.util.Arrays;

public class TableModule extends Module {

    public final static String MODULE_KEY = "tablemodule";

    private Table<SomeObject> someTable;
    private Table<AnotherObject> anotherTable;

    public TableModule() {
        super(MODULE_KEY);
        someTable = createSomeTable();
        anotherTable = createAnotherTable();
    }

    public Table<SomeObject> getSomeTable() {
        return someTable;
    }

    public Table<AnotherObject> getAnotherTable() {
        return anotherTable;
    }

    private Table<AnotherObject> createAnotherTable() {
        AnotherObject s1 = new AnotherObject("String 1:1", "String 1:2");
        AnotherObject s2 = new AnotherObject("String 2:1", "String 2:2");
        ColumnDefinitions<AnotherObject> columnDefinition = new AnotherObjectColumnDefinition();
        return new Table<AnotherObject>(Arrays.asList(s1, s2), columnDefinition);
    }

    private Table<SomeObject> createSomeTable() {
        SomeObject s1 = new SomeObject("Foo 1", "Bar 1", "Baz 1");
        SomeObject s2 = new SomeObject("Foo 2", "Bar 2", "Baz 2");
        SomeObject s3 = new SomeObject("Foo 3", "Bar 3", "Baz 3");
        ColumnDefinitions<SomeObject> columnDefinition = new SomeObjectColumnDefinition();
        return new Table<SomeObject>(Arrays.asList(s1, s2, s3), columnDefinition);
    }

}
