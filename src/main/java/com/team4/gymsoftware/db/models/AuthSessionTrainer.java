package com.team4.gymsoftware.db.models;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.Instant;

@Entity
public class AuthSessionTrainer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "trainer_id",
            referencedColumnName = "id"
    )
    private Trainer trainer;
    private Instant started;
    private String token;

    public Long getId() {
        return id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Instant getStarted() {
        return started;
    }

    public String getToken() {
        return token;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setStarted(Instant started) {
        this.started = started;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
