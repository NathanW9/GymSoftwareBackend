package com.team4.gymsoftware.db.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class ExerciseSection {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int reps;
    private int sets;
    @Nullable
    private int weight;

    @ManyToOne
    @JoinColumn(
            name = "exercise_id",
            referencedColumnName = "id"
    )
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(
            name = "workout_id",
            referencedColumnName = "id"
    )
    private Workout workout;

    public Long getId() {
        return id;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public int getWeight() {
        return weight;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
}
