package com.peejay.report.module.table;

import com.peejay.report.Module;
import com.peejay.report.Table;
import com.peejay.report.domain.AnotherObject;
import com.peejay.report.domain.SomeObject;
import com.peejay.report.domain.ThirdObject;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

public class NaturalTableModule extends Module {

    public final static String MODULE_KEY = "naturaltablemodule";

    private final List<ThirdObject> thirdObjects;

    public NaturalTableModule(List<ThirdObject> thirdObjects) {
        super(MODULE_KEY);
        this.thirdObjects = thirdObjects;
    }

    public List<ThirdObject> getThirdObjects() {
        return thirdObjects;
    }
}
