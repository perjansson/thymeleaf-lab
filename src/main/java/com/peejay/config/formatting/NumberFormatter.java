package com.peejay.config.formatting;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.Formatter;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NumberFormatter implements Formatter<Double> {

    private MessageSource messageSource;

    public NumberFormatter(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public Double parse(final String text, final Locale locale) throws ParseException {
        return Double.parseDouble(text);
    }

    @Override
    public String print(final Double object, final Locale locale) {
        final String format = this.messageSource.getMessage("number.format", null, locale);
        DecimalFormat fmt = new DecimalFormat(format);
        return fmt.format(object);
    }

}
