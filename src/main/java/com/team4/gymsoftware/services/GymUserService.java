package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.db.models.RequestWorkout;
import com.team4.gymsoftware.dto.AssignTrainerRequest;
import com.team4.gymsoftware.dto.CreateGymUserRequest;
import com.team4.gymsoftware.dto.RequestWorkoutRequest;

import java.util.Optional;

public interface GymUserService {

    public Optional<GymUser> saveGymUser(CreateGymUserRequest createGymUserRequest);

    public Optional<GymUser> assignTrainer(AssignTrainerRequest assignTrainerRequest);

    public Optional<RequestWorkout> requestWorkout(RequestWorkoutRequest requestWorkoutRequest);

}
