package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.ExhibitDao;
import com.softserve.academy.museum.model.Exhibit;

import java.util.List;


public interface ExhibitService {
    List<Exhibit> getAll();

    List<Exhibit> getByAuthorId(int authorId);

}
