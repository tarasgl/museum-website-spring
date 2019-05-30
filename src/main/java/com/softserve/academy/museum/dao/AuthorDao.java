package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao {

    List<Author> getAll();

}
