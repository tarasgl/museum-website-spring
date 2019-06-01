package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.ExhibitDao;
import com.softserve.academy.museum.model.Exhibit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitServiceImpl implements ExhibitService {

    @Autowired
    private ExhibitDao exhibitDao;

    @Override
    public List<Exhibit> getAll() {
        return exhibitDao.getAll();
    }

    @Override
    public List<Exhibit> getByAuthorId(int authorId) {
        return exhibitDao.getByAuthorId(authorId);
    }

    @Override
    public List<Exhibit> getByHallId(int hallId) {
        return exhibitDao.getByHallId(hallId);
    }

    @Override
    public List<Exhibit> getByMaterial(String material){
        return exhibitDao.getByMaterial(material);
    }

    @Override
    public List<Exhibit> getByTechnique(String technique){
        return exhibitDao.getByTechnique(technique);
    }

    @Override
    public List<Exhibit> getByEmployeeId(int employeeId) {
        return exhibitDao.getByEmployeeId(employeeId);
    }


}
