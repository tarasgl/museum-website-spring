package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.Excursion;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionDao {

    List<Excursion> getAll();

    List<Excursion> getAvailable(LocalDateTime from, LocalDateTime to);

}
