/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskyi)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Hall;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class HallDaoImpl implements HallDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Hall> getAll() {
        TypedQuery<Hall> query = sessionFactory.getCurrentSession().createQuery("from Hall");
        return query.getResultList();
    }
}
