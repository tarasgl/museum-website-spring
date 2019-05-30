package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    /*@Override
    public Employee getById(int id) {
        return new Employee();
    }*/

    @Override
    @Transactional
    public ArrayList<Employee> getAll() {

        /*ArrayList<Employee> list = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstname("Andrew");
        employee.setLastname("Vash");
        employee.setImage("some");
        Position position = new Position();
        position.setName("Cook");
        position.setId(1);
        employee.setPosition(position);
        list.add(employee);
        return list;*/

        @SuppressWarnings("unchecked")
        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
        ArrayList<Employee> list = (ArrayList<Employee>) query.getResultList();
        return list;

    }

   /* @Override
    public ArrayList<Employee> getAllManagersOnHall() {

        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public ArrayList<Employee> getByPosition(Position position) {
        return null;
    }

    @Override
    public ArrayList<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to) {
        return null;
    }

    @Override
    public int getWorkTime(int id, LocalDateTime from, LocalDateTime to) {
        return 0;
    }

    @Override
    public int getExcursionCount(int id) {
        return 0;
    }*/

}
