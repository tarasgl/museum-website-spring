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

    @Override
    @Transactional
    public List<Employee> getByPosition(Position position) {

        String hql = "from Employee where position.name = :pos";

        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pos", position.getName());

        return query.getResultList();

    }

    @Override
    @Transactional
    public List<Employee> getFreeGuides(LocalDateTime from, LocalDateTime to) {

        String hql = "select distinct e.employee from Excursion e "
                + "where e.start not between :fromDate and :toDate";

        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter("fromDate", from);
        query.setParameter("toDate", to);

        return query.getResultList();

    }

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
