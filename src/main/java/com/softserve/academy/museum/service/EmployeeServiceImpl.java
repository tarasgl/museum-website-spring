package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.EmployeeDao;
import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAll() {

        return employeeDao.getAll();

    }

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

    @Override
    public long getExcursionCount(int id) {

        return employeeDao.getExcursionsCount(id);

    }
}
