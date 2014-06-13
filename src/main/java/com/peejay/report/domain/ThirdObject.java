package com.peejay.report.domain;

import java.util.Date;

public class ThirdObject {

    private String text;
    private Double value;
    private Date date;

    public ThirdObject(String text, Double value, Date date) {
        this.text = text;
        this.value = value;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public Double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
