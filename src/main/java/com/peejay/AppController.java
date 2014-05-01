package com.peejay;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.Arrays;
import java.util.List;
 
@Controller
@RequestMapping("/")
public class AppController {

    @RequestMapping(value="/master", method = RequestMethod.GET)
    public String master(ModelMap model) {
        model.addAttribute("module1", true);
        model.addAttribute("module2", false);
        model.addAttribute("module3", true);
        return "master";
    }
 
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String welcome(ModelMap model) { 
		model.addAttribute("message", "Hello unknown visitor!"); 
		return "index";
	}
 
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		model.addAttribute("message", "Hello " + name + "!");
		return "index";
	}

	@ModelAttribute("allDevelopers")
	public List<String> allDevelopers() {
	    return Arrays.asList("Per", "Tomas", "Bengt");
	}
 
}