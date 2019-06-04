/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.controler;

import com.softserve.academy.museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 *
 * Core servlet controller class for 'excursions' page.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Controller
public class ExcursionController {

    @Autowired
    private ExcursionService excursionService;

    /**
     * Handles request to get all excursions.
     *
     * @param locale Unused parameter for now.
     * @param model Redirect model.
     * @return Path for tiled page to continues processing the request and to be send as response.
     */
    @GetMapping("/excursion")
    public String getExcursion(Locale locale, Model model) {
        model.addAttribute("excursions", excursionService.getAll());
        return "museum-website.excursions";
    }

    /**
     * Handles request to get available excursions for given date-time period or error if input is invalid.
     *
     * @param startDate Start period date-time value in "yyyy-MM-dd HH:mm" format.
     * @param endDate Finish period date-time value in "yyyy-MM-dd HH:mm" format.
     * @param model Redirect model.
     * @return Path for tiled page to continues processing the request and to be send as response.
     */
    @GetMapping(value = "/excursion/getAvailable")
    public String getAvailableExcursions(@RequestParam(name = "from") String startDate,
                                         @RequestParam(name = "to") String endDate, Model model
                                         ) {

        if (startDate.equalsIgnoreCase("all") || endDate.equalsIgnoreCase("all")) {

            model.addAttribute("excursions", excursionService.getAll());
            return "excursions";

        } else {
            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime from = LocalDateTime.parse(startDate, formatter);
                LocalDateTime to = LocalDateTime.parse(endDate, formatter);
                model.addAttribute("excursions", excursionService.getAvailable(from, to));
                return "excursions";

            } catch (DateTimeParseException e) {

                model.addAttribute("description", "Error occurred while processing date and time.");
                return "error";

            } catch (IllegalArgumentException e) {

                model.addAttribute("description", e.getMessage());
                return "error";

            }

        }

    }

}
