package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public ArrayList<Employee> getAll() {

        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
        ArrayList<Employee> list = (ArrayList<Employee>) query.getResultList();
        return list;

    }

}
