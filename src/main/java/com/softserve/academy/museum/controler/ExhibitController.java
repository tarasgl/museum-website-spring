/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskyi)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.controler;

import com.softserve.academy.museum.model.Hall;
import com.softserve.academy.museum.model.Position;
import com.softserve.academy.museum.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller class for exhibit page
 */
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


    /**
     * Handles get request for exhibit page
     * sets all attributes needed for exhibit page and forwards request
     * to museum-website.exhibits tile
     * @param model
     * @return
     */
    @GetMapping("/exhibits")
    public String exhibits(Model model){
        try {
            model.addAttribute("exhibits", exhibitService.getAll());
            model.addAttribute("authors", authorService.getAll());
            model.addAttribute("halls", hallService.getAll());
            model.addAttribute("techniques", techniqueService.getAll());
            model.addAttribute("materials", materialService.gatAll());
            Position managerPosition = new Position();
            managerPosition.setName("manager");
            model.addAttribute("employees", employeeService.getByPosition(managerPosition));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            model.addAttribute("description", "Failed to load exhibit page" + ex.getMessage());
            return "error";
        } catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("description", ex.getMessage());
            return "error";
        }
        return "museum-website.exhibits";
    }


    /**
     * Handles get request for exhibits filtered by author
     * sets exhibits attribute with list of exhibits and forwards request
     * to exhibits.jsp
     * If id is null returns list of all exhibits
     * @param id - Integer, id of author;
     * @param model
     * @return
     */
    @GetMapping("/exhibits/filterByAuthor")
    public String exhibitsByAuthor(@RequestParam(name="authorId") Integer id, Model model){
        try {
            if (id == null) {
                model.addAttribute("exhibits", exhibitService.getAll());
            } else {
                model.addAttribute("exhibits", exhibitService.getByAuthorId(id));
            }
        } catch (IllegalArgumentException ex) {
        ex.printStackTrace();
        model.addAttribute("description", "Failed to load exhibits" + ex.getMessage());
        return "exhibit-error";
    } catch (Exception ex){
        ex.printStackTrace();
        model.addAttribute("description", ex.getMessage());
        return "exhibit-error";
    }
        return "exhibits";
    }


    /**
     * Handles get request for exhibits filtered by hall
     * sets exhibits attribute with list of exhibits and forwards request
     * to exhibits.jsp
     * If id is null returns list of all exhibits
     * @param id - Integer, id of hall;
     * @param model
     * @return
     */
    @GetMapping("/exhibits/filterByHall")
    public String exhibitsByHall(@RequestParam(name="hallId") Integer id, Model model){
        try {
            if (id == null){
                model.addAttribute("exhibits", exhibitService.getAll());
            } else {
                model.addAttribute("exhibits", exhibitService.getByHallId(id));
            }
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            model.addAttribute("description", "Failed to load exhibits" + ex.getMessage());
            return "exhibit-error";
        } catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("description", ex.getMessage());
            return "exhibit-error";
        }
        return "exhibits";
    }

    /**
     * Handles get request for exhibits filtered by material
     * sets exhibits attribute with list of exhibits and forwards request
     * to exhibits.jsp
     * @param material - string, material name
     * @param model
     * @return
     */
    @GetMapping("/exhibits/filterByMaterial")
    public String exhibitsByMaterial(@RequestParam(name="material") String material, Model model){
        try {
            if (material == null || material.isEmpty()){
                model.addAttribute("exhibits", exhibitService.getAll());
            } else {
                model.addAttribute("exhibits", exhibitService.getByMaterial(material));
            }
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            model.addAttribute("description", "Failed to load exhibits" + ex.getMessage());
            return "exhibit-error";
        } catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("description", ex.getMessage());
            return "exhibit-error";
        }
        return "exhibits";
    }

    /**
     * Handles get request for exhibits filtered by technique
     * sets exhibits attribute with list of exhibits and forwards request
     * to exhibits.jsp
     * @param technique - string, technique name
     * @param model
     * @return
     */
    @GetMapping("/exhibits/filterByTechnique")
    public String exhibitsByTechnique(@RequestParam(name="technique") String technique, Model model){
        try {
            if (technique == null || technique.isEmpty()) {
                model.addAttribute("exhibits", exhibitService.getAll());
            } else {
                model.addAttribute("exhibits", exhibitService.getByTechnique(technique));
            }
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            model.addAttribute("description", "Failed to load exhibits" + ex.getMessage());
            return "exhibit-error";
        } catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("description", ex.getMessage());
            return "exhibit-error";
        }
        return "exhibits";
    }

    /**
     * Handles get request for exhibits filtered by employee
     * sets exhibits attribute with list of exhibits and forwards request
     * to exhibits.jsp
     * If employeeId is null returns list of all exhibits
     * @param employeeId - Integer, id of hall;
     * @param model
     * @return
     */
    @GetMapping("/exhibits/filterByEmployee")
    public String exhibitsByEmployeeId(@RequestParam(name="employeeId") Integer employeeId, Model model){
        try {
            if (employeeId == null){
                model.addAttribute("exhibits", exhibitService.getAll());
            } else {
                model.addAttribute("exhibits", exhibitService.getByEmployeeId(employeeId));
            }
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            model.addAttribute("description", "Failed to load exhibits" + ex.getMessage());
            return "exhibit-error";
        } catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("description", ex.getMessage());
            return "exhibit-error";
        }
        return "exhibits";
    }
}
