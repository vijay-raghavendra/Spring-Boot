package com.aim2code.springdemo.mvc.validationdemo;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;

@Controller
public class CustomerController {

    //add an initbinder .. this initbinder method is called
    //ever a web request is made
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor  stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model model)
    {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-Form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid  @ModelAttribute("customer") Customer customer
                ,BindingResult bindingResult)
    {
        //added print statement for debug purpose
        System.out.println("lastName: |"+customer.getLastName()+"|");
        System.out.println("freePasses: |"+customer.getFreePasses()+"|");
        System.out.println("zipCode: |"+customer.getZipCode()+"|");

        if (bindingResult.hasErrors())
        {
            return "customer-Form";
        }
        else
        {
            return "customer-confirmation";
        }
    }

}
