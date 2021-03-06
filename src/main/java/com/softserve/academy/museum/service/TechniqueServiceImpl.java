/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskyi)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
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
