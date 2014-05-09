package com.peejay.report.module.table;

import com.peejay.report.ColumnDefinition;
import com.peejay.report.ColumnDefinitions;
import com.peejay.report.domain.AnotherObject;

public class AnotherObjectColumnDefinition extends ColumnDefinitions<AnotherObject> {

    public AnotherObjectColumnDefinition() {
        addColumn(new OneColumnDefinition());
        addColumn(new TwoColumnDefinition());
    }

    private static class OneColumnDefinition implements ColumnDefinition<AnotherObject> {

        @Override
        public String getHeader() {
            return "Header one";
        }

        @Override
        public String getValue(AnotherObject anotherObject) {
            return anotherObject.getS1();
        }
    }

    private static class TwoColumnDefinition implements ColumnDefinition<AnotherObject> {

        @Override
        public String getHeader() {
            return "Header two";
        }

        @Override
        public String getValue(AnotherObject anotherObject) {
            return anotherObject.getS2();
        }

    }
}
