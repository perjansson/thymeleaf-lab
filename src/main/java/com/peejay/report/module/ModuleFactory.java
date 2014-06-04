package com.peejay.report.module;

import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.jensoftapi.HorizontalBarChartInputDTO;
import com.peejay.report.Module;
import com.peejay.report.domain.ThirdObject;
import com.peejay.report.module.chart.ChartModule;
import com.peejay.report.module.chart.HorizontalBarChartModule;
import com.peejay.report.module.table.NaturalTableModule;
import com.peejay.report.module.table.TableModule;
import com.peejay.report.module.text.TextModule;
import com.peejay.report.domain.Repository;
import com.peejay.report.domain.AnotherObject;
import com.peejay.report.domain.SomeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ModuleFactory {

    @Autowired
    private Repository repository;

    @Autowired
    private ChartFactory chartFactory;

    @Autowired
    private MessageSource messageSource;

    public List<Module> createAllModules() {
        return Arrays.asList(createTextModule(), createNaturalTableModule(), createTableModule(), createChartModule(), createHorizontalBarChartModule());
    }

    public List<Module> createModuleForKeys(List<String> moduleKeys) {
        List<Module> modules = new ArrayList<Module>();
        for (String moduleKey : moduleKeys) {
            modules.add(createModuleForKey(moduleKey));
        }
        return modules;
    }

    public Module createModuleForKey(String moduleKey) {
        Module module = null;
        if (TextModule.MODULE_KEY.equals(moduleKey)) {
            module = createTextModule();
        } else if (NaturalTableModule.MODULE_KEY.equals(moduleKey)) {
            module = createNaturalTableModule();
        } else if (TableModule.MODULE_KEY.equals(moduleKey)) {
            module = createTableModule();
        } else if (ChartModule.MODULE_KEY.equals(moduleKey)) {
            module = createChartModule();
        }
        return module;
    }

    public Module createTextModule() {
        String text = repository.getText();
        return new TextModule(text);
    }

    public Module createNaturalTableModule() {
        List<ThirdObject> thirdObjects = repository.getThirdObjects();
        return new NaturalTableModule(thirdObjects);
    }

    public Module createTableModule() {
        List<SomeObject> someObjects = repository.getSomeObjects();
        List<AnotherObject> anotherObjects = repository.getAnotherObjects();
        return new TableModule(someObjects, anotherObjects, messageSource);
    }

    public Module createChartModule() {
        return new ChartModule(chartFactory);
    }

    private Module createHorizontalBarChartModule() {
        Map<String, Double> inputValues = new TreeMap<String, Double>();
        inputValues.put("Name 1", 60d);
        inputValues.put("Name 2", 30d);
        inputValues.put("Name 3", 10d);
        HorizontalBarChartInputDTO input = new HorizontalBarChartInputDTO(inputValues, 450, 350, "png");
        ChartDTO horizontalBarChart = chartFactory.createHorizontalBarChart(input);
        return new HorizontalBarChartModule(horizontalBarChart);
    }

}
