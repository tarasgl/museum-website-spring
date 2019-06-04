/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskyi)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(max = 45)
    private String name;


    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;


    /**
     * Gets id of a hall.
     *
     * @return Integer id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of a hall.
     *
     * @param id Integer id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the hall.
     *
     * @return String with the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the hall.
     *
     * @param name String the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the employee with manager position
     * who is the manager of the hall.
     *
     * @return Employee object.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the employee with manager position
     * who is the manager of the hall.
     *
     * @param employee Employee object.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employee);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof Hall)) {
            return false;
        }

        Hall hall = (Hall) object;

        return (hall.name.equals(name))
                && (hall.employee.equals(employee));

    }
}
