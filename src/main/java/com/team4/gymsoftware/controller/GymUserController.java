package com.team4.gymsoftware.controller;

import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.db.models.RequestWorkout;
import com.team4.gymsoftware.dto.AssignTrainerRequest;
import com.team4.gymsoftware.dto.CreateGymUserRequest;
import com.team4.gymsoftware.dto.RequestWorkoutRequest;
import com.team4.gymsoftware.services.GymUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GymUserController {

    private GymUserService gymUserService;

    public GymUserController(GymUserService gymUserService) {
        this.gymUserService = gymUserService;
    }

    @PostMapping(path = "/registeruser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody CreateGymUserRequest createGymUserRequest){

        Optional<GymUser> gymUser = gymUserService.saveGymUser(createGymUserRequest);

        if(gymUser.isPresent()){
            return new ResponseEntity<>("Successfully created new user " + gymUser.get().getName()
            + " with id " + gymUser.get().getId(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Could not create user", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/assigntrainer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> assignTrainer(@RequestBody AssignTrainerRequest assignTrainerRequest){

        Optional<GymUser> gymUser = gymUserService.assignTrainer(assignTrainerRequest);

        if(gymUser.isPresent()){
            return new ResponseEntity<>("Successfuly assigned user " + gymUser.get().getName() +
                    " to trainer " + gymUser.get().getTrainer().getName(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Could not assign user: user or trainer do not exist", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/workoutrequest",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> requestWorkout(@RequestBody RequestWorkoutRequest requestWorkoutRequest){
            
            Optional<RequestWorkout> requestWorkout = gymUserService.requestWorkout(requestWorkoutRequest);
    
            if(requestWorkout.isPresent()){
                return new ResponseEntity<>("Successfuly requested workout for user " + requestWorkout.get().getRequester().getName() +
                        " with trainer " + requestWorkout.get().getReceiver().getName(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Could not request workout: user or trainer do not exist", HttpStatus.BAD_REQUEST);
            }
    
        }

        @PostMapping(path = "/getalltrainers",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trainer>> getAllTrainers(){    
            return new ResponseEntity<>(gymUserService.getAllTrainers(), HttpStatus.OK);
        }
}
