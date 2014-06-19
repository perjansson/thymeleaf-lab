package com.peejay.report.module.chart;

import com.peejay.chart.ChartDTO;
import com.peejay.report.Module;
import com.peejay.report.SpecialModule;

public class HorizontalBarChartModule extends Module implements SpecialModule  {

    public final static String MODULE_KEY = "horizontalbarchartmodule";

    private ChartDTO chart;

    public HorizontalBarChartModule(ChartDTO chart) {
        super(MODULE_KEY);
        this.chart = chart;
    }

    public String getChartImage() {
        return encodeToBase64String(chart.getImageAsByteArray());
    }

    @Override
    public String getStyle() {
        return "one";
    }
}
