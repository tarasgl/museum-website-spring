package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Exhibit;

import java.util.List;

public interface ExhibitDao {

    List<Exhibit> getAll();

    List<Exhibit> getByAuthorId(int authorId);

    List<Exhibit> getByHallId(int authorId);

    List<Exhibit> getByMaterial(String material);

    List<Exhibit> getByTechnique(String material);

    List<String> getAllTechniques();

    List<String> getAllMaterials();

}
