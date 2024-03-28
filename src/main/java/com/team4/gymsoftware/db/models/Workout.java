package com.team4.gymsoftware.db.models;

import jakarta.persistence.*;

@Entity
public class Workout {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "trainer_id",
            referencedColumnName = "id"
    )
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(
            name = "gymuser_id",
            referencedColumnName = "id"
    )
    private GymUser gymUser;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public GymUser getGymUser() {
        return gymUser;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setGymUser(GymUser gymUser) {
        this.gymUser = gymUser;
    }
}
