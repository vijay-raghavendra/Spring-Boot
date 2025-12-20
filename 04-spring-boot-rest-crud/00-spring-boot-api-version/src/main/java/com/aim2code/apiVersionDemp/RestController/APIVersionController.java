package com.aim2code.apiVersionDemp.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/{version}/hello")
public class APIVersionController {

    @GetMapping(version = "1")
    public String hello1(){
        return "hello from version 1 API";
    }

    @GetMapping(version = "2")
    public String hello2(){
        return "hello from version 2 API";
    }

    @GetMapping(version = "3")
    public String hello3(){
        return "hello from version 3 API";
    }

}
