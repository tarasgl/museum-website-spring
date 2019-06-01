package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.EmployeeDao;
import com.softserve.academy.museum.dao.EmployeeDaoImpl;
import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public List<Employee> getByPosition(Position position) {
        return employeeDao.getByPosition(position);
    }

    @Override
    public List<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to) {
        return employeeDao.getFreeGuides(from, to);
    }

    @Override
    public long getWorkTime(int id, LocalDateTime from, LocalDateTime to) {
        return employeeDao.getWorkTime(id, from, to);
    }

    @Override
    public long getExcursionCount(int id) {
        return employeeDao.getExcursionsCount(id);
    }
}
