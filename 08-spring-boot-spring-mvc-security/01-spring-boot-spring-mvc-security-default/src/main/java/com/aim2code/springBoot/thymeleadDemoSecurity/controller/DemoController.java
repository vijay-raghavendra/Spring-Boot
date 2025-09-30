package com.aim2code.springBoot.thymeleadDemoSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome()
    {
        return "home";
    }

    //add request mappers for /leaders
    @GetMapping("/leaders")
    public String showLeaders()
    {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems()
    {
        return "systems";
    }
}
