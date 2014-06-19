package com.peejay.report.module.text;

import com.peejay.report.Module;
import com.peejay.report.SpecialModule;

public class TextModule extends Module implements SpecialModule {

    public final static String MODULE_KEY = "textmodule";

    private String text;

    public TextModule(String text) {
        super(MODULE_KEY);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getStyle() {
        return "one";
    }
}
