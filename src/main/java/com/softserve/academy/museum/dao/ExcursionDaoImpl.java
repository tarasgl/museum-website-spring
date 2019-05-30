package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Excursion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
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

}
