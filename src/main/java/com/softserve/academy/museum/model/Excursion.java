/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * Pojo class for 'excursion' database entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Entity
@Table(name = "excursion")
public class Excursion {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "duration")
    private int duration;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    /**
     * Gets 'id' of the excursion.
     *
     * @return 'Id' of the excursion.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets 'id' of the excursion.
     *
     * @param id 'Id' of the excursion.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets start date-time of the excursion.
     *
     * @return Start date-time of the excursion.
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Sets start date-time of the excursion.
     *
     * @param start
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * Gets duration of the excursion in minutes.
     *
     * @return Duration of the excursion.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets duration of the excursion in minutes.
     *
     * @param duration Duration of the excursion.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets name of the excursion.
     *
     * @return Name of the excursion.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the excursion.
     *
     * @param name Name of the excursion.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets employee with 'Guide' position responsible for the excursion.
     *
     * @return Employee responsible for the excursion.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets employee with 'Guide' position responsible for the excursion.
     *
     * @param employee Employee responsible for the excursion.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
