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
    @SuppressWarnings("unchecked")
    public List<Exhibit> getAll() {

        TypedQuery<Exhibit> query = sessionFactory.getCurrentSession().createQuery("from Exhibit");
        return query.getResultList();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Exhibit> getByAuthorId(int authorId){

        TypedQuery<Exhibit> query = sessionFactory.getCurrentSession().createQuery("from Exhibit where author.id = :authorId");
        query.setParameter("authorId", authorId);
        return query.getResultList();
    }


    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Exhibit> getByHallId(int hallId){

        TypedQuery<Exhibit> query = sessionFactory.getCurrentSession().createQuery("from Exhibit where hall.id = :hallId");
        query.setParameter("hallId", hallId);
        return query.getResultList();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Exhibit> getByMaterial(String material){

        TypedQuery<Exhibit> query = sessionFactory.getCurrentSession().createQuery("from Exhibit where material = :material");
        query.setParameter("material", material);
        return query.getResultList();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Exhibit> getByTechnique(String technique){

        TypedQuery<Exhibit> query = sessionFactory.getCurrentSession().createQuery("from Exhibit where technique = :technique");
        query.setParameter("technique", technique);
        return query.getResultList();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<String> getAllTechniques(){
        TypedQuery<String> query = sessionFactory.getCurrentSession().createQuery("select distinct technique from Exhibit");
        return query.getResultList();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<String> getAllMaterials(){
        TypedQuery<String> query = sessionFactory.getCurrentSession().createQuery("select distinct material from Exhibit");
        return query.getResultList();
    }
}
