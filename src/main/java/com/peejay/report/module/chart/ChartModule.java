package com.peejay.report.module.chart;

import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.ChartInputDTO;
import com.peejay.report.Module;
import com.peejay.report.SpecialModule;

import java.util.Map;
import java.util.TreeMap;

public class ChartModule extends Module implements SpecialModule  {

    public final static String MODULE_KEY = "chartmodule";

    private ChartDTO pieChart;
    private ChartDTO backgroundChart;

    public ChartModule(ChartFactory chartFactory) {
        super(MODULE_KEY);

        createCharts(chartFactory);
    }

    private void createCharts(ChartFactory chartFactory) {
        Map<String, Double> input = new TreeMap<String, Double>();
        ChartInputDTO<Map<String, Double>> inputDTO = new ChartInputDTO<Map<String, Double>>(input, 450, 350, "png");
        pieChart = chartFactory.createPieChart(inputDTO);
        backgroundChart = chartFactory.createBackgroundChart(inputDTO);
    }

    public String getSomeChartAsByteArray() {
        return encodeToBase64String(pieChart.getImageAsByteArray());
    }

    public String getAnotherChartAsByteArray() {
        return encodeToBase64String(backgroundChart.getImageAsByteArray());
    }
}
