package com.team4.gymsoftware.dto;

public record CreateWorkoutRequest(String name,
                                   Long trainer_id,
                                   Long user_id,
                                   ExerciseSectionRequest[] exercises) {
}
