package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.repositories.GymUserRepository;
import com.team4.gymsoftware.db.repositories.TrainerRepository;
import com.team4.gymsoftware.dto.AssignTrainerRequest;
import com.team4.gymsoftware.dto.CreateGymUserRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GymUserServiceImpl implements GymUserService{

    private final GymUserRepository gymUserRepository;
    private final TrainerRepository trainerRepository;

    public GymUserServiceImpl(GymUserRepository gymUserRepository,
                              TrainerRepository trainerRepository){
        this.gymUserRepository = gymUserRepository;
        this.trainerRepository = trainerRepository;
    };

    @Override
    public Optional<GymUser> saveGymUser(CreateGymUserRequest createGymUserRequest) {

        if(gymUserRepository.findByName(createGymUserRequest.name()).isPresent()){
            return Optional.empty();
        }

        try{
            if(createGymUserRequest.password().isEmpty()){
                return Optional.empty();
            }
        }
        catch(NullPointerException e){
            return Optional.empty();
        }

        GymUser gymUser = new GymUser();
        gymUser.setName(createGymUserRequest.name());
        gymUser.setPassword(createGymUserRequest.password());

        if(createGymUserRequest.trainer_id() != null){
            Optional<Trainer> trainer = trainerRepository.findById(createGymUserRequest.trainer_id());

            if(trainer.isEmpty()){
                return Optional.empty();
            }

            gymUser.setTrainer(trainer.get());

        }

        return Optional.of(gymUserRepository.save(gymUser));

    }

    @Override
    public Optional<GymUser> assignTrainer(AssignTrainerRequest assignTrainerRequest){

        Optional<Trainer> trainer = trainerRepository.findById(assignTrainerRequest.trainer_id());
        Optional<GymUser> gymUser = gymUserRepository.findById(assignTrainerRequest.user_id());

        if(trainer.isEmpty() || gymUser.isEmpty()){
            return Optional.empty();
        }

        gymUser.get().setTrainer(trainer.get());

        return Optional.of(gymUserRepository.save(gymUser.get()));

    }

    @Override
    public Optional<GymUser> requestWorkout(RequestWorkoutRequest requestWorkoutRequest) {
        Optional<GymUser> gymUser = gymUserRepository.findById(requestWorkoutRequest.user_id());
        Optional<Trainer> trainer = trainerRepository.findById(requestWorkoutRequest.trainer_id());

        if(gymUser.isEmpty() || trainer.isEmpty()){
            return Optional.empty();
        }
        
        gymUser.get().setWorkout_type(requestWorkoutRequest.workout_type());
        gymUser.get().setWorkout_bodyPart(requestWorkoutRequest.workout_bodyPart());
        gymUser.get().setWorkout_intensity(requestWorkoutRequest.workout_intensity());
        gymUser.get().setWorkout_equipment(requestWorkoutRequest.workout_equipment());

        return Optional.of(gymUserRepository.save(gymUser.get()));
    }

}
