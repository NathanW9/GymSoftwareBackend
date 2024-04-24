package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.models.Workout;
import com.team4.gymsoftware.db.repositories.GymUserRepository;
import com.team4.gymsoftware.db.repositories.TrainerRepository;
import com.team4.gymsoftware.db.repositories.WorkoutRepository;
import com.team4.gymsoftware.dto.CreateTrainerRequest;
import com.team4.gymsoftware.dto.RequestWorkoutRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService{

    private final TrainerRepository trainerRepository;
    private final GymUserRepository gymUserRepository;
    private final WorkoutRepository workoutRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository,
                              GymUserRepository gymUserRepository,
                              WorkoutRepository workoutRepository){
        this.trainerRepository = trainerRepository;
        this.gymUserRepository = gymUserRepository;
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Optional<Trainer> saveTrainer(CreateTrainerRequest createTrainerRequest) {

        if(trainerRepository.findByName(createTrainerRequest.name()).isPresent()){
            return Optional.empty();
        }

        try{
            if(createTrainerRequest.password().isEmpty()){
                return Optional.empty();
            }
        }
        catch(NullPointerException e){
            return Optional.empty();
        }

        Trainer trainer = new Trainer();
        trainer.setName(createTrainerRequest.name());
        trainer.setPassword(createTrainerRequest.password());

        return Optional.of(trainerRepository.save(trainer));

    }

    @Override
    public Optional<Workout> createWorkoutFromRequest(RequestWorkoutRequest requestWorkoutRequest) {
        Optional<Trainer> trainer = trainerRepository.findById(requestWorkoutRequest.trainer_id());
        Optional<GymUser> user = gymUserRepository.findById(requestWorkoutRequest.user_id());

        if (trainer.isPresent() && user.isPresent()) {
            Workout workout = new Workout();
            workout.setName("Workout for " + user.get().getName());
            workout.setTrainer(trainer.get());
            workout.setGymUser(user.get());

            return Optional.of(workoutRepository.save(workout));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Workout> assignUserWorkout(RequestWorkoutRequest requestWorkoutRequest) {
        Optional<Workout> workout = workoutRepository.findById(requestWorkoutRequest.workout_id());
        Optional<GymUser> user = gymUserRepository.findById(requestWorkoutRequest.user_id());

        if (workout.isPresent() && user.isPresent()) {
            workout.get().setGymUser(user.get());
            return Optional.of(workoutRepository.save(workout.get()));
        } else {
            return Optional.empty();
        }
    }
}
