package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.ExcursionDao;
import com.softserve.academy.museum.model.Excursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExcursionServiceImpl implements ExcursionService {

    @Autowired
    ExcursionDao excursionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Excursion> getAll() {

        return excursionDao.getAll();

    }

    @Override
    @Transactional(readOnly = true)
    public List<Excursion> getAvailable(LocalDateTime from, LocalDateTime to) throws IllegalArgumentException {

        if (from.isBefore(to)) {

            return excursionDao.getAvailable(from, to);

        } else {

            throw new IllegalArgumentException("Second date value has to be bigger.");

        }

    }


}
