package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Exhibit;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ExhibitDaoImp implements ExhibitDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Exhibit> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Exhibit> query = sessionFactory.getCurrentSession().createQuery("from Exhibit");
        return query.getResultList();
    }

}
