package com.softserve.academy.museum.service;


import com.softserve.academy.museum.dao.ExhibitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechniqueServiceImpl implements TechniqueService {
    @Autowired
    private ExhibitDao exhibitDao;

    @Override
    public List<String> getAll(){
        return exhibitDao.getAllTechniques();
    }
}
