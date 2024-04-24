package com.team4.gymsoftware.db.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class RequestWorkout {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "requester_id",
            referencedColumnName = "id"
    )
    private GymUser requester;

    @ManyToOne
    @JoinColumn(
            name = "receiver_id",
            referencedColumnName = "id"
    )
    private Trainer receiver;
    
    private String title;
    private String description;
    private Instant sent;

    public Long getId() {
        return id;
    }

    public GymUser getRequester() {
        return requester;
    }

    public Trainer getReceiver() {
        return receiver;
    }

    public Instant getSent() {
        return sent;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequester(GymUser requester) {
        this.requester = requester;
    }

    public void setReceiver(Trainer receiver) {
        this.receiver = receiver;
    }

   public void setSent(Instant sent) {
        this.sent = sent;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
