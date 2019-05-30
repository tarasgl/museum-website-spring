package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.AuthorDao;
import com.softserve.academy.museum.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public List<Author> getAll(){
        return authorDao.getAll();
    }
}
