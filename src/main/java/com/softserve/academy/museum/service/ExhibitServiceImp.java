package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.ExhibitDao;
import com.softserve.academy.museum.model.Exhibit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitServiceImp implements ExhibitService {

    @Autowired
    private ExhibitDao exhibitDao;

    @Override
    public List<Exhibit> getAll() {
        return exhibitDao.getAll();
    }
}
