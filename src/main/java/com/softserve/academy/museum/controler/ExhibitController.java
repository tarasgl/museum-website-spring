package com.softserve.academy.museum.controler;

import com.softserve.academy.museum.model.Hall;
import com.softserve.academy.museum.model.Position;
import com.softserve.academy.museum.service.*;
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

    @Autowired
    private HallService hallService;

    @Autowired
    private TechniqueService techniqueService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/exhibits")
    public String exhibits(Model model){
        model.addAttribute("exhibits", exhibitService.getAll());
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("halls", hallService.getAll());
        model.addAttribute("techniques", techniqueService.getAll());
        model.addAttribute("materials", materialService.gatAll());
        Position managerPosition = new Position();
        managerPosition.setName("manager");
        model.addAttribute("employees", employeeService.getByPosition(managerPosition));
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

    @GetMapping("/exhibits/filterByHall")
    public String exhibitsByHall(@RequestParam(name="hallId") Integer id, Model model){
        if (id == null){
            model.addAttribute("exhibits", exhibitService.getAll());
        } else {
            model.addAttribute("exhibits", exhibitService.getByHallId(id));
        }
        return "exhibits";
    }

    @GetMapping("/exhibits/filterByMaterial")
    public String exhibitsByMaterial(@RequestParam(name="material") String material, Model model){
        if (material == null || material.equals("")){
            model.addAttribute("exhibits", exhibitService.getAll());
        } else {
            model.addAttribute("exhibits", exhibitService.getByMaterial(material));
        }
        return "exhibits";
    }

    @GetMapping("/exhibits/filterByTechnique")
    public String exhibitsByTechnique(@RequestParam(name="technique") String technique, Model model){
        if (technique == null || technique.equals("")){
            model.addAttribute("exhibits", exhibitService.getAll());
        } else {
            model.addAttribute("exhibits", exhibitService.getByTechnique(technique));
        }
        return "exhibits";
    }

    @GetMapping("/exhibits/filterByEmployee")
    public String exhibitsByEmployeeId(@RequestParam(name="employeeId") Integer employeeId, Model model){
        if (employeeId == null){
            model.addAttribute("exhibits", exhibitService.getAll());
        } else {
            model.addAttribute("exhibits", exhibitService.getByEmployeeId(employeeId));
        }
        return "exhibits";
    }
}
