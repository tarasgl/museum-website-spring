package com.softserve.academy.museum.controler;

import com.softserve.academy.museum.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String employeeForm(Locale locale, Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "museum-website.employees";
    }


}
