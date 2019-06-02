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

@Controller
public class ExcursionController {

    @Autowired
    private ExcursionService excursionService;

    @GetMapping("/excursion")
    public String getExcursion(Locale locale, Model model) {
        model.addAttribute("excursions", excursionService.getAll());
        return "museum-website.excursions";
    }

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
