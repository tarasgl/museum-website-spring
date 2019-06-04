/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.service;

import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * Service interface for Employee entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
public interface EmployeeService {

    /**
     * Gets all employees.
     *
     * @return List of all employees.
     */
    List<Employee> getAll();

    /**
     * Gets the list of employees by adjusted position.
     *
     * @param position Position the list of employees to be looked by.
     * @return The list of employees by position.
     */
    List<Employee> getByPosition(Position position);

    /**
     * Gets the list of available (free) employees with 'Guide' position
     * by given date-time period (from - to).
     *
     * @param from Start period date-time value.
     * @param to Finish period date-time value.
     * @return The list of free guides.
     */
    List<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to);

    /**
     * Gets the work time (long value standing for minutes) for given 'id' (guide found by given 'id') or 0 if
     * no guide was found. Work time is calculated for given date-time period.
     *
     * @param id 'Id' of guide to be work time calculated for.
     * @param from Start period date-time value.
     * @param to Finish period date-time value.
     * @return Minutes of work for given period.
     */
    long getWorkTime(int id, LocalDateTime from, LocalDateTime to);

    /**
     * Gets the number of done excursions for given 'id' (guide found by given 'id') or
     * 0 if no guide was found. Done excursions are counted from the very beginning till current date-time.
     *
     * @param id 'Id' of guide the number of excursions to be calculated for.
     * @return The number of excursions done.
     */
    long getExcursionCount(int id);

}
