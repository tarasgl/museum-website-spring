/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskyi)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Exhibit;

import java.util.List;

public interface ExhibitDao {

    List<Exhibit> getAll();

    List<Exhibit> getByAuthorId(int authorId);

    List<Exhibit> getByHallId(int authorId);

    List<Exhibit> getByMaterial(String material);

    List<Exhibit> getByTechnique(String material);

    List<Exhibit> getByEmployeeId(int employeeId);

    List<String> getAllTechniques();

    List<String> getAllMaterials();

}
