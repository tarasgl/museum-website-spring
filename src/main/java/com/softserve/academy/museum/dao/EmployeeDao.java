package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface EmployeeDao {

//    Employee getById(int id);

    ArrayList<Employee> getAll();

    /*ArrayList<Employee> getAllManagersOnHall();

    void save(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);

    ArrayList<Employee> getByPosition(Position position);

    ArrayList<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to);

    int getWorkTime(int id, LocalDateTime from, LocalDateTime to);

    int getExcursionCount(int id);*/

}
