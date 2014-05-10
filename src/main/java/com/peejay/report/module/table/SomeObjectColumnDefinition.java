package com.peejay.report.module.table;

import com.peejay.report.ColumnDefinition;
import com.peejay.report.ColumnDefinitions;
import com.peejay.report.domain.SomeObject;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class SomeObjectColumnDefinition extends ColumnDefinitions<SomeObject> {

    public SomeObjectColumnDefinition(MessageSource messageSource, Locale locale) {
        addColumn(new FooColumnDefinition(messageSource, locale));
        addColumn(new BarColumnDefinition(messageSource, locale));
        addColumn(new BazColumnDefinition(messageSource, locale));
    }

    private static class FooColumnDefinition implements ColumnDefinition<SomeObject> {

        private MessageSource messageSource;
        private Locale locale;

        public FooColumnDefinition(MessageSource messageSource, Locale locale) {
            this.messageSource = messageSource;
            this.locale = locale;
        }

        @Override
        public String getHeader() {
            return messageSource.getMessage("tablemodule.sometable.column1.header", null, locale);
        }

        @Override
        public String getValue(SomeObject someObject) {
            return someObject.getFoo();
        }
    }

    private static class BarColumnDefinition implements ColumnDefinition<SomeObject> {

        private MessageSource messageSource;
        private Locale locale;

        public BarColumnDefinition(MessageSource messageSource, Locale locale) {
            this.messageSource = messageSource;
            this.locale = locale;
        }

        @Override
        public String getHeader() {
            return messageSource.getMessage("tablemodule.sometable.column2.header", null, locale);
        }

        @Override
        public String getValue(SomeObject someObject) {
            return someObject.getBar();
        }

    }

    private static class BazColumnDefinition implements ColumnDefinition<SomeObject> {

        private MessageSource messageSource;
        private Locale locale;

        public BazColumnDefinition(MessageSource messageSource, Locale locale) {
            this.messageSource = messageSource;
            this.locale = locale;
        }

        @Override
        public String getHeader() {
            return messageSource.getMessage("tablemodule.sometable.column3.header", null, locale);
        }

        @Override
        public String getValue(SomeObject someObject) {
            return someObject.getBaz();
        }

    }
}
