package com.peejay.report.module;

import com.peejay.report.Module;
import com.peejay.report.repository.ChartDataRepository;
import com.peejay.table.AnotherObject;
import com.peejay.table.SomeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ModuleFactory {

    @Autowired
    private ChartDataRepository repository;

    public List<Module> createAllModules() {
        return Arrays.asList(createTextModule(), createTableModule(), createChartModule());
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

    public Module createTableModule() {
        List<SomeObject> someObjects = repository.getSomeObjects();
        List<AnotherObject> anotherObjects = repository.getAnotherObjects();
        return new TableModule(someObjects, anotherObjects);
    }

    public Module createChartModule() {
        return new ChartModule();
    }

}
