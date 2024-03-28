package com.team4.gymsoftware.db.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exercise {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String bodyGroup;
    @Nullable
    private String machine;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBodyGroup() {
        return bodyGroup;
    }

    public String getMachine() {
        return machine;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBodyGroup(String bodyGroup) {
        this.bodyGroup = bodyGroup;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

}
