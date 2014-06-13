package com.peejay.config.formatting;

import org.junit.Before;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;

public class PercentFormatterTest {

    private PercentFormatter percentFormatter;

    @Before
    public void setUp() {
        percentFormatter = new PercentFormatter();
    }

    @Test
    public void shouldFormatInteger() {
        // given
        Number number = 0.255;
        // when
        String result = percentFormatter.formatInteger(number);
        // then
        assertThat(result).isEqualTo("26%");
    }

    @Test
    public void shouldFormatOneDecimal() {
        // given
        Number number = 0.255;
        // when
        String result = percentFormatter.formatOneDecimal(number);
        // then
        assertThat(result).isEqualTo("25,5%");
    }

    @Test
    public void shouldFormatIntegerNoConversion() {
        // given
        Number number = 25.5;
        // when
        String result = percentFormatter.formatIntegerNoConversion(number);
        // then
        assertThat(result).isEqualTo("26%");
    }

    @Test
    public void shouldFormatOneDecimalNoConversion() {
        // given
        Number number = 25.5;
        // when
        String result = percentFormatter.formatOneDecimalNoConversion(number);
        // then
        assertThat(result).isEqualTo("25,5%");
    }

    @Test
    public void shouldNotFormatNull() {
        // then
        assertThat(percentFormatter.formatInteger(null)).isNull();
        assertThat(percentFormatter.formatOneDecimal(null)).isNull();
        assertThat(percentFormatter.formatIntegerNoConversion(null)).isNull();
        assertThat(percentFormatter.formatOneDecimalNoConversion(null)).isNull();
    }

}
