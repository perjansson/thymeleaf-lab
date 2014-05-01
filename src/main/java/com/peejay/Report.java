package com.peejay;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<Module> modules = new ArrayList<Module>();

    public Report(List<Module> modules) {
        this.modules = modules;
    }

    public List<Module> getModules() {
        return modules;
    }

    public boolean hasModule(String moduleName) {
        Module moduleToFind = new Module(moduleName);
        return modules.contains(moduleToFind);
    }

}
