package com.softserve.academy.museum.controler;

import com.softserve.academy.museum.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExhibitController {
    @Autowired
    private ExhibitService exhibitService;

    @GetMapping("/exhibits")
    public String exhibits(Model model){
        model.addAttribute("exhibits", exhibitService.getAll());
        return "museum-website.exhibits";
    }
}
