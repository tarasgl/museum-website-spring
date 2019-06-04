package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.ExcursionDao;
import com.softserve.academy.museum.dao.ExcursionDaoImpl;
import com.softserve.academy.museum.model.Excursion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExcursionServiceImplTest {

    @InjectMocks
    private ExcursionService excursionService = new ExcursionServiceImpl();

    @Mock
    private ExcursionDao excursionDao = new ExcursionDaoImpl();

    // Default values for tests
    private static LocalDateTime DEFAULT_FROM_DATE_TIME = LocalDateTime.parse("1999-12-12T10:22:00");
    private static LocalDateTime DEFAULT_TO_DATE_TIME = LocalDateTime.parse("2019-12-12T10:22:00");

    @After
    public void finalize() {
        excursionService = null;
        excursionDao = null;
    }

    @Test
    public void getAllTest() {
        List<Excursion> excursionList = new ArrayList<>();
        Excursion excursion = new Excursion();
        excursion.setName("Excursion name");
        excursionList.add(excursion);

        when(excursionDao.getAll()).thenReturn(excursionList);
        Assert.assertEquals(excursionService.getAll(), excursionList);
        Assert.assertEquals(excursionService.getAll().get(0).getName(), "Excursion name");
    }

    @Test
    public void getAvailableTest() {
        List<Excursion> excursionList = new ArrayList<>();
        Excursion excursion = new Excursion();
        excursion.setName("Excursion name");
        excursionList.add(excursion);

        when(excursionDao.getAvailable(DEFAULT_FROM_DATE_TIME, DEFAULT_TO_DATE_TIME)).thenReturn(excursionList);

        Assert.assertEquals(excursionService.getAvailable(DEFAULT_FROM_DATE_TIME, DEFAULT_TO_DATE_TIME), excursionList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAvailableNullDateTimeExceptionTest() {
        excursionService.getAvailable(DEFAULT_FROM_DATE_TIME, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAvailableInvalidDateTimeValuesExceptionTest() {
        excursionService.getAvailable(DEFAULT_TO_DATE_TIME, DEFAULT_FROM_DATE_TIME);
    }

}