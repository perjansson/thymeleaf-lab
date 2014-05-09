package com.peejay.report.module.table;

import com.peejay.report.Module;
import com.peejay.report.Table;
import com.peejay.report.domain.AnotherObject;
import com.peejay.report.domain.SomeObject;

import java.util.List;

public class TableModule extends Module {

    public final static String MODULE_KEY = "tablemodule";

    private List<SomeObject> someObjects;
    private List<AnotherObject> anotherObjects;

    public TableModule(List<SomeObject> someObjects, List<AnotherObject> anotherObjects) {
        super(MODULE_KEY);
        this.someObjects = someObjects;
        this.anotherObjects = anotherObjects;
    }

    public Table<SomeObject> getSomeTable() {
        return new Table<SomeObject>(someObjects, new SomeObjectColumnDefinition());
    }

    public Table<AnotherObject> getAnotherTable() {
        return new Table<AnotherObject>(anotherObjects, new AnotherObjectColumnDefinition());
    }

}
