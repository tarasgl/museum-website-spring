/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.service;

import com.softserve.academy.museum.model.Excursion;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * Service interface for Excursion entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
public interface ExcursionService {

    /**
     * Gets all excursions.
     *
     * @return List of all excursions.
     */
    List<Excursion> getAll();

    /**
     * Gets all available excursions for given date-time period.
     *
     * @param from Start period date-time value.
     * @param to Finish period date-time value.
     * @return List of all available excursions.
     */
    List<Excursion> getAvailable(LocalDateTime from, LocalDateTime to);

}
