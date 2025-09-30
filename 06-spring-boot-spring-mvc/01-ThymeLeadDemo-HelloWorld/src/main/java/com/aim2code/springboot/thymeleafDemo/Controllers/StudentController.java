package com.aim2code.springboot.thymeleafDemo.Controllers;

import com.aim2code.springboot.thymeleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programmingLanguages}")
    private List<String> progLanguages;

    @Value("${operatingSystems}")
    public List<String> oprSystem;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {


        //Create new Student object
        Student student = new Student();

        //add the student object to the model
        model.addAttribute("student", student);

        //Adding the few attributes from application.properties
        model.addAttribute("countries", countries);
        model.addAttribute("progLanguages", progLanguages);
        model.addAttribute("operatingSystems", oprSystem);

        return "student-Form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {

        System.out.println("The Student with name : " +
                student.getFirstName() + " " + student.getLastName() +
                " Is present in the Database");

        return "student-Confirmation";
    }

}
