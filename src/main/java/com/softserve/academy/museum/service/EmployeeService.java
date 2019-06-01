package com.softserve.academy.museum.service;

import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    ArrayList<Employee> getAll();

    List<Employee> getByPosition(Position position);

    List<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to);

    long getWorkTime(int id, LocalDateTime from, LocalDateTime to);

    long getExcursionCount(int id);

}
