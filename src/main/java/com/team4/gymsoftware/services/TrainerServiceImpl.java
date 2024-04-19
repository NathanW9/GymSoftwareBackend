package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.repositories.TrainerRepository;
import com.team4.gymsoftware.dto.CreateTrainerRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService{

    private final TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
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
        Optional<Trainer> trainer = trainerRepository.findById(requestWorkoutRequest.getTrainerId());
        Optional<GymUser> user = gymUserRepository.findById(requestWorkoutRequest.getUserId());

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
}
