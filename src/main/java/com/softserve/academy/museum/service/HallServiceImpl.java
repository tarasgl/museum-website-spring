package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.HallDao;
import com.softserve.academy.museum.model.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private HallDao hallDao;

    @Override
    public List<Hall> getAll() {
        return hallDao.getAll();
    }
}
