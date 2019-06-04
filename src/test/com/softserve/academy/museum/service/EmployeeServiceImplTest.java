package com.softserve.academy.museum.service;

import com.softserve.academy.museum.dao.EmployeeDao;
import com.softserve.academy.museum.dao.EmployeeDaoImpl;
import com.softserve.academy.museum.model.Employee;
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
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Mock
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    private static int DEFAULT_NUMBER_OF_EMPLOYEES = 5;

    @After
    public void finalize() {
        employeeService = null;
        employeeDao = null;
    }

    @Test
    public void getAllPositiveResult() {
        List<Employee> employeeList = createList(DEFAULT_NUMBER_OF_EMPLOYEES);

        when(employeeDao.getAll()).thenReturn(employeeList);

        Assert.assertEquals(employeeService.getAll(), employeeList);
        int listIndex = 1;
        Assert.assertEquals(employeeService.getAll().get(listIndex).getFirstname(), "Name" + (listIndex+1));
    }

    @Test
    public void getAllPositiveEmptyListResult() {
        List<Employee> employeeList = new ArrayList<>();

        when(employeeDao.getAll()).thenReturn(employeeList);

        Assert.assertEquals(employeeService.getAll(), employeeList);
    }

    @Test
    public void getByPositionPositiveTest() {

        List<Employee> employeeList = createList(DEFAULT_NUMBER_OF_EMPLOYEES);
        Position guidePosition = new Position();
        Position managerPosition = new Position();
        guidePosition.setName("Guide");
        managerPosition.setName("Manager");

        // odd index in the employeeList stands for manager
        int odd = 1;
        // even index in the employeeList stands for guide
        int even = 2;

        List<Employee> guideList = new ArrayList<>();
        guideList.add(employeeList.get(even));
        when(employeeDao.getByPosition(guidePosition)).thenReturn(guideList);

        List<Employee> managerList = new ArrayList<>();
        managerList.add(employeeList.get(odd));
        when(employeeDao.getByPosition(managerPosition)).thenReturn(managerList);

        Assert.assertEquals(employeeService.getByPosition(guidePosition).get(0).getPosition().getName(), guidePosition.getName());

        Assert.assertEquals(employeeService.getByPosition(managerPosition).get(0).getPosition().getName(), managerPosition.getName());

    }

    @Test(expected = IllegalArgumentException.class)
    public void getByPositionExceptionTest() {
        Position notExistingPosition = new Position();
        notExistingPosition.setName("Some random name");
        notExistingPosition.setId(1);

        employeeService.getByPosition(notExistingPosition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFreeGuidesDateNullExceptionTest() {
        employeeService.getWorkTime(1, null, LocalDateTime.parse("1212-12-12T11:11:00"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFreeGuidesIncorrectDateValuesExceptionTest() {
        employeeService.getWorkTime(1, LocalDateTime.parse("2019-12-12T10:22:00"), LocalDateTime.parse("1999-12-12T10:22:00"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWorkTimeIncorrectDateValuesExceptionTest() {
        employeeService.getWorkTime(1, LocalDateTime.parse("2019-12-12T10:22:00"), LocalDateTime.parse("1999-12-12T10:22:00"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWorkTimeNullDateExceptionTest() {
        employeeService.getWorkTime(1, null, LocalDateTime.parse("1999-12-12T10:22:00"));
    }

    private List<Employee> createList(int count) {

        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Employee employee = new Employee();
            employee.setId(i+1);
            employee.setFirstname("Name" + (i+1));
            employee.setLastname("Lastname" + (i+1));
            employee.setImage((i+1) + ".jpg");
            Position position = new Position();
            if ((i%2) == 0) {
                position.setId(1);
                position.setName("Guide");
            } else {
                position.setId(2);
                position.setName("Manager");
            }
            employee.setPosition(position);
            employeeList.add(employee);
        }

        return employeeList;

    }

}