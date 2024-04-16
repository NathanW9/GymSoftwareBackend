package com.team4.gymsoftware.db.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class AuthSessionUser {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private GymUser user;
    private Instant started;
    private String token;

    public Long getId() {
        return id;
    }

    public GymUser getUser() {
        return user;
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

    public void setUser(GymUser user) {
        this.user = user;
    }

    public void setStarted(Instant started) {
        this.started = started;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
