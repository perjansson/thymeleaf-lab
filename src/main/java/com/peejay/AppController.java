package com.peejay;

import com.peejay.chart.ChartDTO;
import com.peejay.chart.ChartFactory;
import com.peejay.chart.ChartInputDTO;
import com.peejay.config.environment.Environment;
import com.peejay.exception.ModuleNotFoundException;
import com.peejay.report.Report;
import com.peejay.report.module.ModuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private ModuleFactory moduleFactory;

    @Autowired
    private ChartFactory chartFactory;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String report(ModelMap model) {
        System.out.println("Creating report in environment: " + environment.getName());
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
        if (moduleKey.equals("notFound")) {
            System.err.println("Module: " + moduleKey + " is not found! 404 on that my friend!");
            throw new ModuleNotFoundException();
        }
        Report report = new Report(moduleFactory.createModuleForKey(moduleKey));
        model.addAttribute("report", report);
        return moduleKey;
    }

    @ResponseBody
    @RequestMapping(value = "/charts/pie", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] pieChart(ModelMap model) {
        Map<String, Double> inputs = new TreeMap<String, Double>();
        ChartInputDTO<Map<String, Double>> inputDTO = new ChartInputDTO<Map<String, Double>>(inputs, 700, 500, "png");
        ChartDTO pieChart = chartFactory.createPieChart(inputDTO);
        return pieChart.getImageAsByteArray();
    }

    @ResponseBody
    @RequestMapping(value = "/charts/background", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] backgroundChart(ModelMap model) {
        Map<String, Double> inputs = new TreeMap<String, Double>();
        ChartInputDTO<Map<String, Double>> inputDTO = new ChartInputDTO<Map<String, Double>>(inputs, 700, 500, "png");
        ChartDTO pieChart = chartFactory.createBackgroundChart(inputDTO);
        return pieChart.getImageAsByteArray();
    }

    @ModelAttribute("allDevelopers")
    public List<String> allDevelopers() {
        return Arrays.asList("Per", "Tomas", "Bengt");
    }

    @RequestMapping(value = "/pagebreak", method = RequestMethod.GET)
    public String pageBreak() {
        return "pagebreak";
    }

}