package com.peejay.report.module.table;

import com.peejay.report.Module;
import com.peejay.report.Table;
import com.peejay.report.domain.AnotherObject;
import com.peejay.report.domain.SomeObject;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

public class TableModule extends Module {

    public final static String MODULE_KEY = "tablemodule";

    private final List<SomeObject> someObjects;
    private final List<AnotherObject> anotherObjects;
    private final MessageSource messageSource;

    public TableModule(List<SomeObject> someObjects, List<AnotherObject> anotherObjects, MessageSource messageSource) {
        super(MODULE_KEY);
        this.someObjects = someObjects;
        this.anotherObjects = anotherObjects;
        this.messageSource = messageSource;
    }

    public Table<SomeObject> getSomeTable() {
        return new Table<SomeObject>(someObjects, new SomeObjectColumnDefinition(messageSource, LocaleContextHolder.getLocale()));
    }

    public Table<AnotherObject> getAnotherTable() {
        return new Table<AnotherObject>(anotherObjects, new AnotherObjectColumnDefinition(messageSource, LocaleContextHolder.getLocale()));
    }

}
