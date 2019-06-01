package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.ExhibitDao;
import com.softserve.academy.museum.model.Exhibit;

import java.util.List;


public interface ExhibitService {
    List<Exhibit> getAll();

    List<Exhibit> getByAuthorId(int authorId);

    List<Exhibit> getByHallId(int hallId);

    List<Exhibit> getByMaterial(String material);

    List<Exhibit> getByTechnique(String material);

    List<Exhibit> getByEmployeeId(int employeeId);

}
