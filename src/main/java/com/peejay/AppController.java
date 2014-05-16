package com.peejay;

import com.peejay.chart.ChartFactory;
import com.peejay.chart.jensoftapi.JenSoftAPIChartFactory;
import com.peejay.report.ChartUtil;
import com.peejay.report.Report;
import com.peejay.report.module.ModuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private ModuleFactory moduleFactory;

    // TODO: How do we get this in here?
    private ChartFactory chartFactory = new JenSoftAPIChartFactory();

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String report(ModelMap model) {
        Report report = new Report(moduleFactory.createAllModules());
        model.addAttribute("report", report);
        return "report";
    }

    @RequestMapping(value = "/report/{moduleKeys}", method = RequestMethod.GET)
    public String reportModules(@PathVariable List<String> moduleKeys, ModelMap model) {
        Report report = new Report(moduleFactory.createModuleForKeys(moduleKeys));
        model.addAttribute("report", report);
        return "report";
    }

    @RequestMapping(value = "/report/modules/{moduleKey}", method = RequestMethod.GET)
    public String module1(@PathVariable String moduleKey, ModelMap model) {
        Report report = new Report(moduleFactory.createModuleForKey(moduleKey));
        model.addAttribute("report", report);
        return "modules/" + moduleKey;
    }

    @ResponseBody
    @RequestMapping(value = "/charts/pie", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] pieChart(ModelMap model) {
        return ChartUtil.toImageByteArray(chartFactory.createPieChart(), 700, 500, "png");
    }

    @ResponseBody
    @RequestMapping(value = "/charts/background", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] backgroundChart(ModelMap model) {
        return ChartUtil.toImageByteArray(chartFactory.createBackgroundChart(), 700, 500, "png");
    }

    @ModelAttribute("allDevelopers")
    public List<String> allDevelopers() {
        return Arrays.asList("Per", "Tomas", "Bengt", "Ganesh", "Shweta", "Prajakta");
    }

}