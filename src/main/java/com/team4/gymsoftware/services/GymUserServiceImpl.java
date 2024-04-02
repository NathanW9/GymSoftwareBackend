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

        GymUser gymUser = new GymUser();
        gymUser.setName(createGymUserRequest.name());

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

}
