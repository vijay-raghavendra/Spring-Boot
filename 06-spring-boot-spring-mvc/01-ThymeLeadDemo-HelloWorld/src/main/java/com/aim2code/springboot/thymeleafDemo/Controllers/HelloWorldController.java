package com.aim2code.springboot.thymeleafDemo.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //Need a Controller Method to show initial HTML Form
    @RequestMapping("/showForm")
    public String ShowForm() {
        return "helloWorld-form";
    }

    //Need a Controller Method to process the HTML Form
    @RequestMapping("/processForm")
    public String ProcessForm() {
        return "helloWorld";
    }

    //Need a controller to read the form data and add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude (HttpServletRequest request, Model model) {

        //Read the request parameter from the html form
        String name = request.getParameter("firstName");
        //convert to upper case
        name = name.toUpperCase();
        //create your own message
        name = "Yo - "+name;
        //Add to the model
        model.addAttribute("message", name);
        return "helloworld";

    }

    @PostMapping("/processFormV3")
    public String letsShoutDudeLoud (@RequestParam("firstName") String name, Model model) {

        //convert to upper case
        name = name.toUpperCase();
        //create your own message
        name = "Yo YO - "+name;
        //Add to the model
        model.addAttribute("message", name);
        return "helloworld";

    }
}
