package com.peejay.report.module.table;

import com.peejay.report.ColumnDefinition;
import com.peejay.report.ColumnDefinitions;
import com.peejay.report.domain.AnotherObject;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class AnotherObjectColumnDefinition extends ColumnDefinitions<AnotherObject> {

    public AnotherObjectColumnDefinition(MessageSource messageSource, Locale locale) {
        addColumn(new OneColumnDefinition(messageSource, locale));
        addColumn(new TwoColumnDefinition(messageSource, locale));
    }

    private static class OneColumnDefinition implements ColumnDefinition<AnotherObject> {

        private MessageSource messageSource;
        private Locale locale;

        public OneColumnDefinition(MessageSource messageSource, Locale locale) {
            this.messageSource = messageSource;
            this.locale = locale;
        }

        @Override
        public String getHeader() {
            return messageSource.getMessage("tablemodule.anothertable.column1.header", null, locale);
        }

        @Override
        public String getValue(AnotherObject anotherObject) {
            return anotherObject.getS1();
        }
    }

    private static class TwoColumnDefinition implements ColumnDefinition<AnotherObject> {

        private MessageSource messageSource;
        private Locale locale;

        public TwoColumnDefinition(MessageSource messageSource, Locale locale) {
            this.messageSource = messageSource;
            this.locale = locale;
        }

        @Override
        public String getHeader() {
            return messageSource.getMessage("tablemodule.anothertable.column2.header", null, locale);
        }

        @Override
        public String getValue(AnotherObject anotherObject) {
            return anotherObject.getS2();
        }

    }
}
