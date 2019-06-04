/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Position;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * DAO implementation for Employee entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets all employees.
     *
     * @return List of all employees.
     */
    @Override
    @Transactional
    public List<Employee> getAll() {

        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
        ArrayList<Employee> list = (ArrayList<Employee>) query.getResultList();
        return list;

    }

    /**
     * Gets the list of employees by adjusted position.
     *
     * @param position Position the list of employees to be looked by.
     * @return The list of employees by position.
     */
    @Override
    @Transactional
    public List<Employee> getByPosition(Position position) {

        String hql = "from Employee where position.name = :pos";

        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pos", position.getName());

        return query.getResultList();

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
    @Transactional
    public List<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to) {

        String hql = "select em from Employee em where em.position.name = 'Guide' and em.id not in (" +
                "select distinct ex.employee.id from Excursion ex where ex.start between :fromDate and :toDate)";

        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter("fromDate", from);
        query.setParameter("toDate", to);

        return query.getResultList();

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
    @Transactional
    public long getWorkTime(int id, LocalDateTime from, LocalDateTime to) {

        String hql = "select sum(e.duration) from Excursion e where e.employee.id = :id and e.start between :fromDate and :toDate";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id", id);
        query.setParameter("fromDate", from);
        query.setParameter("toDate", to);

        Object result = query.getSingleResult();

        if (result != null) {
            return (Long) query.getSingleResult();
        } else {
            return 0;
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
    @Transactional
    public long getExcursionsCount(int id) {

        String hql = "select count(*) from Excursion e where e.employee.id = :id and e.start < current_time";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id", id);

        Object result = query.getSingleResult();

        if (result != null) {
            return (Long) query.getSingleResult();
        } else {
            return 0;
        }

    }

}
