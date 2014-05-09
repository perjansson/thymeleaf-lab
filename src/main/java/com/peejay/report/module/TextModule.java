package com.peejay.report.module;

import com.peejay.report.Module;

public class TextModule extends Module {

    public final static String MODULE_KEY = "textmodule";

    private String text;

    public TextModule() {
        super(MODULE_KEY);
        text = "A simple text";
    }

    public String getText() {
        return text;
    }
}
