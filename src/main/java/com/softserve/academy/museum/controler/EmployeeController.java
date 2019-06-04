/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.controler;

import com.softserve.academy.museum.model.Position;
import com.softserve.academy.museum.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 *
 * Core servlet controller class for 'employees' page.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Handles request to get all employees.
     *
     * @param locale Unused parameter for now.
     * @param model Redirect model.
     * @return Path for tiled page to continues processing the request and to be send as response.
     */
    @GetMapping("/employee")
    public String employeeForm(Locale locale, Model model) {

        model.addAttribute("employees", employeeService.getAll());
        return "museum-website.employees";

    }

    /**
     * Handles request to get employees with given position or error if input data is invalid.
     *
     * @param position Position to be looked for throughout all employees.
     * @param model Redirect model.
     * @return Path for tiled page to continues processing the request and to be send as response.
     */
    @GetMapping("/employee/position")
    public String positionFiltering(@RequestParam(name = "position") String position,
                                        Model model) {

        if(position.equalsIgnoreCase("all") || position.isEmpty()) {

            model.addAttribute("employees", employeeService.getAll());
            return "employees";

        } else {

            Position pos = new Position();
            pos.setName(position);
            try {

                model.addAttribute("employees", employeeService.getByPosition(pos));
                return "employees";

            } catch (IllegalArgumentException e) {

                model.addAttribute("description", e.getMessage());
                return "error";

            }

        }

    }

    /**
     * Handles request to get free employees with 'Guide' position for given date-time
     * period or error if input data is invalid.
     *
     * @param startDate Start period date-time value in "yyyy-MM-dd HH:mm" format.
     * @param endDate Finish period date-time value in "yyyy-MM-dd HH:mm" format.
     * @param model Redirect model.
     * @return Path for tiled page to continues processing the request and to be send as response.
     */
    @GetMapping("/employee/free")
    public String findFreeGuides(@RequestParam(name = "from") String startDate,
                                 @RequestParam(name = "to") String endDate, Model model
                                ) {

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime from = LocalDateTime.parse(startDate, formatter);
            LocalDateTime to = LocalDateTime.parse(endDate, formatter);
            model.addAttribute("employees", employeeService.getFreeGuides(from, to));
            return "employees";

        } catch (DateTimeParseException e) {

            model.addAttribute("description", "Error occurred while processing date and time.");
            return "error";

        } catch (IllegalArgumentException e) {

            model.addAttribute("description", e.getMessage());
            return "error";

        }

    }

    /**
     * Handles request to get work time in minutes for employee 'id'
     * (employee with 'Guide' position with given 'id') for given date-time period
     * or error if input is invalid.
     *
     * @param id Employee 'id'.
     * @param startDate Start period date-time value in "yyyy-MM-dd HH:mm" format.
     * @param endDate Finish period date-time value in "yyyy-MM-dd HH:mm" format.
     * @param model Unused parameter for now.
     * @return Work time in minutes.
     */
    @GetMapping("/employee/getWorkTime")
    @ResponseBody
    public String getWorkTime(@RequestParam(name = "id") Integer id,
                              @RequestParam(name = "from") String startDate,
                              @RequestParam(name = "to") String endDate,
                              Model model) {

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime from = LocalDateTime.parse(startDate, formatter);
            LocalDateTime to = LocalDateTime.parse(endDate, formatter);

            return Long.toString(employeeService.getWorkTime(id, from, to));

        } catch (DateTimeParseException e) {

            return "Error occurred while processing date and time.";

        } catch (IllegalArgumentException e) {

            return e.getMessage();

        }

    }

    /**
     * Handles request to get the number of done excursions by current date-time for employee 'id'
     * (employee with 'Guide' position with given 'id') or error if input is invalid.
     *
     * @param id Employee 'id'.
     * @param model Unused parameter for now.
     * @return The number of done excursions.
     */
    @GetMapping("/employee/getExcursionsCount")
    @ResponseBody
    public String getExcursionsCount(@RequestParam(name = "id") Integer id,
                                     Model model
                                            ) {

        try {

            return Long.toString(employeeService.getExcursionCount(id));

        } catch (IllegalArgumentException e) {

            return e.getMessage();

        }

    }

}
