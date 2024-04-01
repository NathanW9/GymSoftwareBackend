package com.team4.gymsoftware.dto;

public record EditWorkoutRequest(CreateWorkoutRequest createWorkoutRequest,
                                 long workoutId) {
}
