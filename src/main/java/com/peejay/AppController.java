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