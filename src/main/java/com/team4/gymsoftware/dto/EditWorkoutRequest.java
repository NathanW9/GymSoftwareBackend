package com.team4.gymsoftware.dto;

public record EditWorkoutRequest(String token,
                                 CreateWorkoutRequest createWorkoutRequest,
                                 long workoutId) {
}
