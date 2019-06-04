/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Excursion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * DAO implementation for Excursion entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Repository
@Transactional
public class ExcursionDaoImpl implements ExcursionDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets all excursions.
     *
     * @return List of all excursions.
     */
    @Override
    public List<Excursion> getAll() {
        TypedQuery<Excursion> query = sessionFactory.getCurrentSession().createQuery("from Excursion");
        List<Excursion> list = query.getResultList();
        return list;
    }

    /**
     * Gets all available excursions for given date-time period.
     *
     * @param from Start period date-time value.
     * @param to Finish period date-time value.
     * @return List of all available excursions.
     */
    @Override
    public List<Excursion> getAvailable(LocalDateTime from, LocalDateTime to) {

        String hql = "from Excursion e where e.start between :start and :finish";

        TypedQuery<Excursion> query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter("start", from);
        query.setParameter("finish", to);

        return query.getResultList();
    }


}
