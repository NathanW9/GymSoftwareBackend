package com.team4.gymsoftware.db.models;

import jakarta.persistence.*;

@Entity
public class Trainer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    @OneToMany
    @JoinColumn(
            name = "workout_id",
            referencedColumnName = "id"
    )
    private List<RequestWorkout> workoutRequests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
