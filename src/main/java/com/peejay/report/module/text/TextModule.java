package com.peejay.report.module.text;

import com.peejay.report.Module;

public class TextModule extends Module {

    public final static String MODULE_KEY = "textmodule";

    private String text;

    public TextModule(String text) {
        super(MODULE_KEY);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
