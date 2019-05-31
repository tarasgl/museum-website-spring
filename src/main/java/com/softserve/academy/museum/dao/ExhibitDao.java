package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Exhibit;

import java.util.List;

public interface ExhibitDao {

    List<Exhibit> getAll();

    List<Exhibit> getByAuthorId(int authorId);

}
