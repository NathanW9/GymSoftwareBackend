package com.team4.gymsoftware.dto;

import com.team4.gymsoftware.db.models.RequestWorkout;

public record CreateWorkoutRequest(String name,
                                   RequestWorkout requestWorkout,
                                   Long trainer_id,
                                   Long user_id,
                                   ExerciseSectionRequest[] exercises) {
}
