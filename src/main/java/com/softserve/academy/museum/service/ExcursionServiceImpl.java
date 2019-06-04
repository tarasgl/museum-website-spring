/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.ExcursionDao;
import com.softserve.academy.museum.model.Excursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * Service implementation for Excursion entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Service
public class ExcursionServiceImpl implements ExcursionService {

    @Autowired
    ExcursionDao excursionDao;

    /**
     * Gets all excursions.
     *
     * @return List of all excursions.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Excursion> getAll() {

        return excursionDao.getAll();

    }

    /**
     * Gets all available excursions for given date-time period.
     *
     * @param from Start period date-time value.
     * @param to Finish period date-time value.
     * @return List of all available excursions.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Excursion> getAvailable(LocalDateTime from, LocalDateTime to) throws IllegalArgumentException {
        if (from != null && to != null) {
            if (from.isBefore(to)) {
                return excursionDao.getAvailable(from, to);
            } else {
                throw new IllegalArgumentException("Second date value has to be bigger.");
            }
        } else {
            throw new IllegalArgumentException("Date must have a value and not to be null.");
        }

    }


}
