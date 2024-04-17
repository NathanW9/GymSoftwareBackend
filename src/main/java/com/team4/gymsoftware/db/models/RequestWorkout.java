package com.team4.gymsoftware.db.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RequestWorkout {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainer_id;
    private Long user_id;
    private String workout_type;
    private String workout_bodyPart;
    private String workout_intensity;
    private Boolean workout_equipment;

    public Long getUserId() {
        return user_id;
    }

    public Long getTrainerId() {
        return trainer_id;
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

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public void setTrainerId(Long trainer_id) {
        this.trainer_id = trainer_id;
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
}
