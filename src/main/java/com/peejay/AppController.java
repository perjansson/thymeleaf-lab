package com.peejay;

import com.peejay.jensoftapi.ChartUtil;
import com.peejay.jensoftapi.PieChart;
import com.peejay.table.ColumnDefinitions;
import com.peejay.table.SomeObject;
import com.peejay.table.SomeObjectColumnDefinition;
import com.peejay.table.Table;
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

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String report(ModelMap model) {
        Module module1 = new Module("module1");
        Module module2 = new Module("module2");
        Module module3 = new Module("module3");
        List<Module> modules = Arrays.asList(module1, module2, module3);
        Report report = new Report(modules);
        model.addAttribute("report", report);
        PieChart pieChart = new PieChart();
        model.addAttribute("module3chart", ChartUtil.toImageBase64EncodedByteArray(pieChart, 700, 500, "png"));
        model.addAttribute(createTable());
        return "report";
    }

    private Table<SomeObject> createTable() {
        SomeObject s1 = new SomeObject("Foo 1", "Bar 1");
        SomeObject s2 = new SomeObject("Foo 2", "Bar 2");
        ColumnDefinitions<SomeObject> columnDefinition = new SomeObjectColumnDefinition();
        return new Table<SomeObject>(Arrays.asList(s1, s2), columnDefinition);
    }

    @RequestMapping(value = "/report/{moduleKeys}", method = RequestMethod.GET)
    public String reportModules(@PathVariable List<String> moduleKeys, ModelMap model) {
        List<Module> modules = new ArrayList<Module>();
        for (String moduleKey : moduleKeys) {
            modules.add(new Module(moduleKey));
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
        return Arrays.asList("Per", "Tomas", "Bengt");
    }

}