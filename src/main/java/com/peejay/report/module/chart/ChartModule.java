package com.peejay.report.module.chart;

import com.peejay.chart.Chart;
import com.peejay.chart.ChartFactory;
import com.peejay.report.ChartUtil;
import com.peejay.report.Module;

public class ChartModule extends Module {

    public final static String MODULE_KEY = "chartmodule";

    private Chart pieChart;
    private Chart backgroundChart;

    public ChartModule(ChartFactory chartFactory) {
        super(MODULE_KEY);

        createCharts(chartFactory);
    }

    private void createCharts(ChartFactory chartFactory) {
        pieChart = chartFactory.createPieChart();
        backgroundChart = chartFactory.createBackgroundChart();
    }

    public String getSomeChartAsByteArray() {
        return ChartUtil.toImageBase64EncodedByteArray(pieChart, 450, 350, "png");
    }

    public String getAnotherChartAsByteArray() {
        return ChartUtil.toImageBase64EncodedByteArray(backgroundChart, 450, 350, "png");
    }
}
