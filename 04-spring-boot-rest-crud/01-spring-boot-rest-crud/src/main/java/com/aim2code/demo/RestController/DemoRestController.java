package com.aim2code.demo.RestController;

import com.aim2code.demo.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class DemoRestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello Vijay";
    }


}
