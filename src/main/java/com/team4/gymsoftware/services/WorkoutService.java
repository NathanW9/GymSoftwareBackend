package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.Workout;
import com.team4.gymsoftware.dto.*;

import java.util.List;
import java.util.Optional;

public interface WorkoutService {

    public Optional<Workout> saveWorkout(CreateWorkoutRequest createWorkOutRequest);

    public Optional<Workout> patchWorkout(EditWorkoutRequest editWorkoutRequest);

    public List<Workout> getWorkouts(Long userId);

}
