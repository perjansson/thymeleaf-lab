package com.peejay.config.conversion;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        synchronized (SDF) {
            final Date date = SDF.parse(text);
            final Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(date.getTime());
            return cal.getTime();
        }
    }

    @Override
    public String print(Date date, Locale locale) {
        synchronized (SDF) {
            return SDF.format(date);
        }
    }

}
