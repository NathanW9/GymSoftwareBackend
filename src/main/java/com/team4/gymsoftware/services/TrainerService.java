package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.RequestWorkout;
import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.models.Workout;
import com.team4.gymsoftware.dto.CreateTrainerRequest;
import com.team4.gymsoftware.dto.RequestWorkoutRequest;

import java.util.List;
import java.util.Optional;

public interface TrainerService {

    public Optional<Trainer> saveTrainer(CreateTrainerRequest createTrainerRequest);

    public List<RequestWorkout> getRequests(long trainerId);

}
