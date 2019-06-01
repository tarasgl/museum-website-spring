package com.softserve.academy.museum.service;

import com.softserve.academy.museum.model.Excursion;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionService {

    List<Excursion> getAll();

    List<Excursion> getAvailable(LocalDateTime from, LocalDateTime to);

}
