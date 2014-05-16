package com.peejay.report.module.chart;

import com.peejay.chart.ChartFactory;
import com.peejay.chart.jensoftapi.JenSoftAPIChartFactory;
import com.peejay.chart.jensoftapi.background.BackgroundImageChart;
import com.peejay.report.ChartUtil;
import com.peejay.report.Module;

public class ChartModule extends Module {

    public final static String MODULE_KEY = "chartmodule";

    // TODO: How do we get this in here?
    private ChartFactory chartFactory = new JenSoftAPIChartFactory();

    private String someChartAsByteArray;
    private String anotherChartAsByteArray;

    public ChartModule() {
        super(MODULE_KEY);
        someChartAsByteArray = ChartUtil.toImageBase64EncodedByteArray(chartFactory.createPieChart(), 450, 350, "png");
        anotherChartAsByteArray = ChartUtil.toImageBase64EncodedByteArray(chartFactory.createBackgroundChart(), 450, 350, "png");
    }

    public String getSomeChartAsByteArray() {
        return someChartAsByteArray;
    }

    public String getAnotherChartAsByteArray() {
        return anotherChartAsByteArray;
    }
}
