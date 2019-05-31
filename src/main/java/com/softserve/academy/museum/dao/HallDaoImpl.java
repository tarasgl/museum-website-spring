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
