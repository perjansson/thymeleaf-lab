package com.peejay.config.formatting;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PercentFormatter {

    private final NumberFormat integerFormat;
    private final NumberFormat oneDecimalFormat;

    public PercentFormatter() {
        integerFormat = NumberFormat.getPercentInstance();
        integerFormat.setMinimumFractionDigits(0);
        oneDecimalFormat = NumberFormat.getPercentInstance();
        oneDecimalFormat.setMinimumFractionDigits(1);
        ((DecimalFormat) oneDecimalFormat).setParseBigDecimal(true);
    }

    public String formatInteger(Number number) {
        return nullSafeFormat(integerFormat, number);
    }

    public String formatOneDecimal(Number number) {
        return nullSafeFormat(oneDecimalFormat, number);
    }

    public String formatIntegerNoConversion(Number number) {
        return number != null ? formatInteger(number.doubleValue() / 100) : null;
    }

    public String formatOneDecimalNoConversion(Number number) {
        return number != null ? formatOneDecimal(number.doubleValue() / 100) : null;
    }

    private String nullSafeFormat(NumberFormat formatter, Number number) {
        return number != null ? formatter.format(number) : null;
    }
}
