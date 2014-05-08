package com.peejay.table;

import java.util.List;

public class SomeObjectColumnDefinition extends ColumnDefinitions<SomeObject> {

    public SomeObjectColumnDefinition() {
        addColumn(new FooColumnDefinition());
        addColumn(new BarColumnDefinition());
    }

    private static class FooColumnDefinition implements ColumnDefinition<SomeObject> {

        @Override
        public String getValue(SomeObject someObject) {
            return someObject.getFoo();
        }
    }

    private static class BarColumnDefinition implements ColumnDefinition<SomeObject> {

        @Override
        public String getValue(SomeObject someObject) {
            return someObject.getBar();
        }

    }
}
