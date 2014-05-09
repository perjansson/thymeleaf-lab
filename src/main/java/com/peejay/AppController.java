package com.peejay;

import com.peejay.jensoftapi.BackgroundImageChart;
import com.peejay.jensoftapi.ChartUtil;
import com.peejay.jensoftapi.PieChart;
import com.peejay.report.Module;
import com.peejay.report.Report;
import com.peejay.report.module.ChartModule;
import com.peejay.report.module.ModuleFactory;
import com.peejay.report.module.TableModule;
import com.peejay.report.module.TextModule;
import com.peejay.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private ModuleFactory moduleFactory;

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String report(ModelMap model) {
        model.addAttribute("report", new Report(moduleFactory.createAllModules()));
        return "report";
    }

    @RequestMapping(value = "/report/{moduleKeys}", method = RequestMethod.GET)
    public String reportModules(@PathVariable List<String> moduleKeys, ModelMap model) {
        List<Module> modules = new ArrayList<Module>();
        for (String moduleKey : moduleKeys) {
            modules.add(moduleFactory.createModuleForKey(moduleKey));
        }
        Report report = new Report(modules);
        model.addAttribute("report", report);
        return "report";
    }

    @RequestMapping(value = "/report/module/{moduleKey}", method = RequestMethod.GET)
    public String module1(@PathVariable String moduleKey, ModelMap model) {
        return "modules/" + moduleKey;
    }

    @ResponseBody
    @RequestMapping(value = "/chart/pie", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] jensoftapi(ModelMap model) {
        PieChart pieChart = new PieChart();
        return ChartUtil.toImageByteArray(pieChart, 700, 500, "png");
    }

    @ModelAttribute("allDevelopers")
    public List<String> allDevelopers() {
        return Arrays.asList("Per", "Tomas", "Bengt", "Ganesh", "Shweta", "Prajakta");
    }

}