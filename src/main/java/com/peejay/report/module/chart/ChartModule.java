package com.peejay.report.module.chart;

import com.peejay.report.ChartUtil;
import com.peejay.report.Module;

public class ChartModule extends Module {

    public final static String MODULE_KEY = "chartmodule";

    private String someChartAsByteArray;
    private String anotherChartAsByteArray;

    public ChartModule() {
        super(MODULE_KEY);
        someChartAsByteArray = ChartUtil.toImageBase64EncodedByteArray(new PieChart(), 450, 350, "png");
        anotherChartAsByteArray = ChartUtil.toImageBase64EncodedByteArray(new BackgroundImageChart(), 450, 350, "png");
    }

    public String getSomeChartAsByteArray() {
        return someChartAsByteArray;
    }

    public String getAnotherChartAsByteArray() {
        return anotherChartAsByteArray;
    }
}
