package com.peejay.report.module;

import com.peejay.report.Module;
import com.peejay.report.repository.ChartDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ModuleFactory {

    @Autowired
    private ChartDataRepository repository;

    public List<Module> createAllModules() {
        return Arrays.asList(createTextModule(), createTableModule(), createChartModule());
    }

    public Module createModuleForKey(String moduleKey) {
        Module module = null;
        if (TextModule.MODULE_KEY.equals(moduleKey)) {
            module = createTextModule();
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

    public Module createChartModule() {
        return new ChartModule();
    }

    public Module createTableModule() {
        return new TableModule();
    }
}
