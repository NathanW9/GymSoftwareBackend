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
    private String workout_type;
    private String workout_bodyPart;
    private String workout_intensity;
    private Boolean workout_equipment;
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

    public String getWorkoutType() {
        return workout_type;
    }

    public String getWorkoutBodyPart() {
        return workout_bodyPart;
    }

    public String getWorkoutIntensity() {
        return workout_intensity;
    }

    public Boolean getWorkoutEquipment() {
        return workout_equipment;
    }

    public Instant getSent() {
        return sent;
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

    public void setWorkoutType(String workout_type) {
        this.workout_type = workout_type;
    }

    public void setWorkoutBodyPart(String workout_bodyPart) {
        this.workout_bodyPart = workout_bodyPart;
    }

    public void setWorkoutIntensity(String workout_intensity) {
        this.workout_intensity = workout_intensity;
    }

    public void setWorkoutEquipment(Boolean workout_equipment) {
        this.workout_equipment = workout_equipment;
    }

    public void setSent(Instant sent) {
        this.sent = sent;
    }
}
