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

    @GetMapping("/employee/position")
    public String positionFiltering(@RequestParam(name = "position") String position,
                                        Model model) {

        if(position.equalsIgnoreCase("all") || position.isEmpty()) {

            model.addAttribute("employees", employeeService.getAll());

        } else {

            Position pos = new Position();
            pos.setName(position);
            model.addAttribute("employees", employeeService.getByPosition(pos));

        }

        return "employees";

    }

    @GetMapping("/employee/free")
    public String findFreeGuides(@RequestParam(name = "from") String startDate,
                                 @RequestParam(name = "to") String endDate, Model model
                                ) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime from = LocalDateTime.parse(startDate, formatter);
        LocalDateTime to = LocalDateTime.parse(endDate, formatter);

        model.addAttribute("employees", employeeService.getFreeGuides(from, to));

        return "employees";

    }

    @GetMapping("/employee/getWorkTime")
    @ResponseBody
    public String getWorkTime(@RequestParam(name = "id") Integer id,
                              @RequestParam(name = "from") String startDate,
                              @RequestParam(name = "to") String endDate,
                              Model model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime from = LocalDateTime.parse(startDate, formatter);
        LocalDateTime to = LocalDateTime.parse(endDate, formatter);

        return Long.toString(employeeService.getWorkTime(id, from, to));

    }

}
