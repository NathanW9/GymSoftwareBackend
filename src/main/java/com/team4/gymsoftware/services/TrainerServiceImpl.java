package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.db.models.RequestWorkout;
import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.models.Workout;
import com.team4.gymsoftware.db.repositories.GymUserRepository;
import com.team4.gymsoftware.db.repositories.RequestWorkoutRepository;
import com.team4.gymsoftware.db.repositories.TrainerRepository;
import com.team4.gymsoftware.db.repositories.WorkoutRepository;
import com.team4.gymsoftware.dto.CreateTrainerRequest;
import com.team4.gymsoftware.dto.RequestWorkoutRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService{

    private final TrainerRepository trainerRepository;
    private final GymUserRepository gymUserRepository;
    private final WorkoutRepository workoutRepository;
    private final RequestWorkoutRepository requestWorkoutRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository,
                              GymUserRepository gymUserRepository,
                              WorkoutRepository workoutRepository,
                              RequestWorkoutRepository requestWorkoutRepository){
        this.trainerRepository = trainerRepository;
        this.gymUserRepository = gymUserRepository;
        this.workoutRepository = workoutRepository;
        this.requestWorkoutRepository = requestWorkoutRepository;
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
    public List<RequestWorkout> getRequests(long trainerId) {

        Trainer trainer = trainerRepository.findById(trainerId).get();

        return requestWorkoutRepository.findAllByReceiver(trainer);

    }

}
