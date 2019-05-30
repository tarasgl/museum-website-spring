package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthorDaoImp implements AuthorDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Author> getAll() {
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("from Author");
        return query.getResultList();
    }
}
