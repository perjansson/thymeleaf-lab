package com.peejay.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Report {

    private List<Module> modules;

    public Report(List<Module> modules) {
        this.modules = modules;
    }

    public Report(Module module) {
        this.modules = Arrays.asList(module);
    }

    public List<Module> getModules() {
        return modules;
    }

    public boolean hasModule(String moduleKey) {
        for (Module module : modules) {
            if (module.getKey().equals(moduleKey)) {
                return true;
            }
        }
        return false;
    }

    public Module getModule(String moduleKey) {
        for (Module module : modules) {
            if (module.getKey().equals(moduleKey)) {
                return module;
            }
        }
        return null;
    }

}
