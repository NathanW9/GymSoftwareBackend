package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.models.Workout;
import com.team4.gymsoftware.db.repositories.*;
import com.team4.gymsoftware.dto.CreateWorkoutRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    private final WorkoutRepository workoutRepository;
    private final GymUserRepository gymUserRepository;
    private final TrainerRepository trainerRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository,
                              GymUserRepository gymUserRepository,
                              TrainerRepository trainerRepository){
        this.workoutRepository = workoutRepository;
        this.gymUserRepository = gymUserRepository;
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Optional<Workout> saveWorkout(CreateWorkoutRequest createWorkoutRequest) {
        if(workoutRepository.findByNameAndGymUser(createWorkoutRequest.name(),
                gymUserRepository.findById(createWorkoutRequest.user_id()).orElseThrow()).isEmpty()){

            Workout workout = new Workout();
            workout.setName(createWorkoutRequest.name());
            workout.setTrainer(trainerRepository.findById(createWorkoutRequest.trainer_id()).orElseThrow());
            workout.setGymUser(gymUserRepository.findById(createWorkoutRequest.user_id()).orElseThrow());

            return Optional.of(workoutRepository.save(workout));
        }
        return Optional.empty();
    }
}
