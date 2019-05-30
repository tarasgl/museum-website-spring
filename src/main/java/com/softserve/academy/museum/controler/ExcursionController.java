package com.softserve.academy.museum.controler;

import com.softserve.academy.museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class ExcursionController {

    @Autowired
    private ExcursionService excursionService;

    @GetMapping("/excursion")
    public String getExcursion(Locale locale, Model model) {
        model.addAttribute("excursions", excursionService.getAll());
        return "museum-website.excursions";
    }

}
