package com.peejay;

import com.peejay.jensoftapi.ChartUtil;
import com.peejay.jensoftapi.PieChart;
import com.peejay.table.*;
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
        model.addAttribute("someTable", createSomeTable());
        model.addAttribute("anotherTable", createAnotherTable());
        model.addAttribute("someChart", ChartUtil.toImageBase64EncodedByteArray(new PieChart(), 700, 500, "png"));
        return "report";
    }

    private Table<AnotherObject> createAnotherTable() {
        AnotherObject s1 = new AnotherObject("String 1:1", "String 1:2");
        AnotherObject s2 = new AnotherObject("String 2:1", "String 2:2");
        ColumnDefinitions<AnotherObject> columnDefinition = new AnotherObjectColumnDefinition();
        return new Table<AnotherObject>(Arrays.asList(s1, s2), columnDefinition);
    }

    private Table<SomeObject> createSomeTable() {
        SomeObject s1 = new SomeObject("Foo 1", "Bar 1", "Baz 1");
        SomeObject s2 = new SomeObject("Foo 2", "Bar 2", "Baz 2");
        SomeObject s3 = new SomeObject("Foo 3", "Bar 3", "Baz 3");
        ColumnDefinitions<SomeObject> columnDefinition = new SomeObjectColumnDefinition();
        return new Table<SomeObject>(Arrays.asList(s1, s2, s3), columnDefinition);
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
        return Arrays.asList("Per", "Tomas", "Bengt", "Ganesh", "Shweta", "Prajakta");
    }

}