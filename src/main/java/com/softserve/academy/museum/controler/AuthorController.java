package com.softserve.academy.museum.controler;


import com.softserve.academy.museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String userForm( Model model) {
        model.addAttribute("authors", authorService.getAll());
        return "authors";
    }

}
