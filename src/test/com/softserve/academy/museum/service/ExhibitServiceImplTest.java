package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.EmployeeDao;
import com.softserve.academy.museum.dao.EmployeeDaoImpl;
import com.softserve.academy.museum.dao.ExhibitDao;
import com.softserve.academy.museum.dao.ExhibitDaoImpl;
import com.softserve.academy.museum.model.Employee;
import com.softserve.academy.museum.model.Exhibit;
import com.softserve.academy.museum.model.Position;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class ExhibitServiceImplTest {

    @InjectMocks
    private ExhibitService exhibitService = new ExhibitServiceImpl();

    @Mock
    private ExhibitDao exhibitDao = new ExhibitDaoImpl();

    @Test
    public void getExhibitByTechniquePositive(){
        List<Exhibit> exhibits = new ArrayList<Exhibit>();
        Exhibit exhibit = new Exhibit();
        exhibit.setTechnique("sampleTechnique");

        when(exhibitDao.getByTechnique("sampleTechnique")).thenReturn(exhibits);

       assertEquals(exhibitService.getByTechnique("sampleTechnique"), exhibits);

    }
}
