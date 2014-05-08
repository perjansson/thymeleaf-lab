package com.peejay.table;

import java.util.List;

public class SomeObjectColumnDefinition extends ColumnDefinitions<SomeObject> {

    public SomeObjectColumnDefinition() {
        addColumn(new FooColumnDefinition());
        addColumn(new BarColumnDefinition());
        addColumn(new BazColumnDefinition());
    }

    private static class FooColumnDefinition implements ColumnDefinition<SomeObject> {

        @Override
        public String getHeader() {
            return "Header 1";
        }

        @Override
        public String getValue(SomeObject someObject) {
            return someObject.getFoo();
        }
    }

    private static class BarColumnDefinition implements ColumnDefinition<SomeObject> {

        @Override
        public String getHeader() {
            return "Header 2";
        }

        @Override
        public String getValue(SomeObject someObject) {
            return someObject.getBar();
        }

    }

    private static class BazColumnDefinition implements ColumnDefinition<SomeObject> {

        @Override
        public String getHeader() {
            return "Header 3";
        }

        @Override
        public String getValue(SomeObject someObject) {
            return someObject.getBaz();
        }

    }
}
