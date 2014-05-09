package com.peejay.report.domain;

public class SomeObject {

    private String foo;
    private String bar;
    private String baz;

    public SomeObject(String foo, String bar, String baz) {
        this.foo = foo;
        this.bar = bar;
        this.baz = baz;
    }

    public String getBar() {
        return bar;
    }

    public String getFoo() {
        return foo;
    }

    public String getBaz() {
        return baz;
    }
}
