package com.team4.gymsoftware.dto;

public record CreateWorkoutRequest(String name,
                                   RequestWorkout requestWorkout,
                                   Long trainer_id,
                                   Long user_id,
                                   ExerciseSectionRequest[] exercises) {
}
