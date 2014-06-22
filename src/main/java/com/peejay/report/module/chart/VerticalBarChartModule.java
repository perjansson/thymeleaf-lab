package com.peejay.report.module.chart;

import com.peejay.chart.ChartDTO;
import com.peejay.report.Module;
import com.peejay.report.SpecialModule;

public class VerticalBarChartModule extends Module implements SpecialModule  {

    public final static String MODULE_KEY = "verticalbarchartmodule";

    private ChartDTO chart;

    public VerticalBarChartModule(ChartDTO chart) {
        super(MODULE_KEY);
        this.chart = chart;
    }

    public String getChartImage() {
        return encodeToBase64String(chart.getImageAsByteArray());
    }
}
