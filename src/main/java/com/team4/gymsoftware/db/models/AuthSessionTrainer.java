package com.team4.gymsoftware.db.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.catalina.User;

import java.time.Instant;

public class AuthSessionTrainer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;

    private Trainer trainer;
    private Instant started;
    private String token;

}
