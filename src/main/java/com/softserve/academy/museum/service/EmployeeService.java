package com.softserve.academy.museum.service;

import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    Employee getById(int id);

    ArrayList<Employee> getAll();

    ArrayList<Employee> getAllManagersOnHall();

    void save(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);

    List<Employee> getByPosition(Position position);

    List<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to);

    long getWorkTime(int id, LocalDateTime from, LocalDateTime to);

    int getExcursionCount(int id);

}
