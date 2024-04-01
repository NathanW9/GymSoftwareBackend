package com.team4.gymsoftware.dto;

import jakarta.annotation.Nullable;

public record ExerciseSectionRequest(int sets,
                                     int reps,
                                     @Nullable int weight,
                                     String exercise) {

}
