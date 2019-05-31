package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Excursion;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class ExcursionDaoImpl implements ExcursionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Excursion> getAll() {
        TypedQuery<Excursion> query = sessionFactory.getCurrentSession().createQuery("from Excursion");
        List<Excursion> list = query.getResultList();
        return list;
    }

    @Override
    public List<Excursion> getAvailable(LocalDateTime from, LocalDateTime to) {

        String hql = "from Excursion e where e.start between :start and :finish";

        TypedQuery<Excursion> query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter("start", from);
        query.setParameter("finish", to);

        return query.getResultList();
    }


}
