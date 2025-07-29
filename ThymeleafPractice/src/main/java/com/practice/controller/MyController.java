package com.practice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        System.out.println("Inside About Handler");
        model.addAttribute("name", "Adesh Dhage"); 
        model.addAttribute("contact", "9090455052");
        return "about";
    }
    
    @GetMapping("/iterate-example")
    public String iterateHandler(Model model)
    {
    	List<String> names = List.of("Fred Perry","Ralph Lauren","Balman Paris"," Hackett Landon");
    	model.addAttribute("names", names);
    	
    	return "iterate";
    }
    
   @GetMapping("/condition") 
    public String conditionHandler(Model m)
    {
	   m.addAttribute("isActive",true);
	   m.addAttribute("gender", "M");
    	return "condition";
    }

}
