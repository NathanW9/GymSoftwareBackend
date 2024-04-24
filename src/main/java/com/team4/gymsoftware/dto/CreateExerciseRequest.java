package com.team4.gymsoftware.dto;

public record CreateExerciseRequest (int reps,
                                     int sets,
                                     int weight,
                                     String exerciseName){
        }
