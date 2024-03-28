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

}
