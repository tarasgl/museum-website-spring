package com.softserve.academy.museum.controler;

import com.softserve.academy.museum.service.AuthorService;
import com.softserve.academy.museum.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExhibitController {
    @Autowired
    private ExhibitService exhibitService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/exhibits")
    public String exhibits(Model model){
        model.addAttribute("exhibits", exhibitService.getAll());
        model.addAttribute("authors", authorService.getAll());
        return "museum-website.exhibits";
    }

    @GetMapping("/exhibits/filterByAuthor")
    public String exhibitsByAuthor(@RequestParam(name="authorId") Integer id, Model model){
        if (id == null){
            model.addAttribute("exhibits", exhibitService.getAll());
        } else {
            model.addAttribute("exhibits", exhibitService.getByAuthorId(id));
        }
        return "exhibits";
    }
}
