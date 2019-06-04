/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.EmployeeDao;
import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * Service implementation for Employee entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;

    /**
     * Gets all employees.
     *
     * @return List of all employees.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAll() {

        return employeeDao.getAll();

    }

    /**
     * Gets the list of employees by adjusted position.
     *
     * @param position Position the list of employees to be looked by.
     * @return The list of employees by position.
     */
    @Override
    public List<Employee> getByPosition(Position position) throws IllegalArgumentException {
        if (position != null && !position.getName().isEmpty()) {
            List<Employee> empList = employeeDao.getByPosition(position);
            if ((empList.isEmpty() && !position.getName().equalsIgnoreCase("MANAGER")
                    && !position.getName().equalsIgnoreCase("GUIDE")) || empList == null) {
                throw new IllegalArgumentException("Not existing position.");
            } else {
                return empList;
            }
        } else {
            throw new IllegalArgumentException("Position must have value and not to be null.");
        }

    }

    /**
     * Gets the list of available (free) employees with 'Guide' position
     * by given date-time period (from - to).
     *
     * @param from Start period date-time value.
     * @param to Finish period date-time value.
     * @return The list of free guides.
     */
    @Override
    public List<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to) throws IllegalArgumentException {
        if (from != null && to != null) {
            if (from.isBefore(to)) {
                return employeeDao.getFreeGuides(from, to);
            } else {
                throw new IllegalArgumentException("Second date value has to be bigger.");
            }
        } else {
            throw new IllegalArgumentException("Date must have a value and not to be null.");
        }
    }

    /**
     * Gets the work time (long value standing for minutes) for given 'id' (guide found by given 'id') or 0 if
     * no guide was found. Work time is calculated for given date-time period.
     *
     * @param id 'Id' of guide to be work time calculated for.
     * @param from Start period date-time value.
     * @param to Finish period date-time value.
     * @return Minutes of work for given period.
     */
    @Override
    public long getWorkTime(int id, LocalDateTime from, LocalDateTime to) throws IllegalArgumentException {
        if (from != null && to != null) {
            if (from.isBefore(to)) {
                return employeeDao.getWorkTime(id, from, to);
            } else {
                throw new IllegalArgumentException("Second date value has to be bigger.");
            }
        } else {
            throw new IllegalArgumentException("Date must have a value and not to be null.");
        }

    }

    /**
     * Gets the number of done excursions for given 'id' (guide found by given 'id') or
     * 0 if no guide was found. Done excursions are counted from the very beginning till current date-time.
     *
     * @param id 'Id' of guide the number of excursions to be calculated for.
     * @return The number of excursions done.
     */
    @Override
    public long getExcursionCount(int id) {

        return employeeDao.getExcursionsCount(id);

    }
}
