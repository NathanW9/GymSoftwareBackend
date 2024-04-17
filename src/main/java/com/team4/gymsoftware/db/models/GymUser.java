package com.team4.gymsoftware.db.models;

import jakarta.persistence.*;

@Entity
public class GymUser {

    @Id @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    @ManyToOne
    @JoinColumn(
            name = "trainer_id",
            referencedColumnName = "id"
    )
    private Trainer trainer;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
