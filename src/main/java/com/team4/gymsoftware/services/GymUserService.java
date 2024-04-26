package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.db.models.RequestWorkout;
import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.dto.AssignTrainerRequest;
import com.team4.gymsoftware.dto.CreateGymUserRequest;
import com.team4.gymsoftware.dto.RequestWorkoutRequest;

import java.util.List;
import java.util.Optional;

public interface GymUserService {

    public Optional<GymUser> saveGymUser(CreateGymUserRequest createGymUserRequest);

    public Optional<GymUser> assignTrainer(AssignTrainerRequest assignTrainerRequest);

    public List<Trainer> getAllTrainers();

    public Optional<RequestWorkout> requestWorkout(RequestWorkoutRequest requestWorkoutRequest);

    public Optional<GymUser> getUserByIdIfExists(long id);
    

}
