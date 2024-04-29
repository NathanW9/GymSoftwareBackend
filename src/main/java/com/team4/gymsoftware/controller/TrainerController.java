package com.team4.gymsoftware.controller;

import com.team4.gymsoftware.auth.AuthService;
import com.team4.gymsoftware.db.models.RequestWorkout;
import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.models.Workout;
import com.team4.gymsoftware.dto.CreateTrainerRequest;
import com.team4.gymsoftware.dto.GetRequestsRequest;
import com.team4.gymsoftware.dto.RequestWorkoutRequest;
import com.team4.gymsoftware.services.TrainerService;
import com.team4.gymsoftware.services.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {

    private TrainerService trainerService;
    private WorkoutService workoutService;
    private AuthService authService;

    public TrainerController(TrainerService trainerService, WorkoutService workoutService, AuthService authService) {
        this.trainerService = trainerService;
        this.workoutService = workoutService;
        this.authService = authService;
    }

    @PostMapping(path = "/registertrainer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createTrainer(@RequestBody CreateTrainerRequest createTrainerRequest) {

        Optional<Trainer> trainer = trainerService.saveTrainer(createTrainerRequest);

        if (trainer.isPresent()) {
            return new ResponseEntity<>("Successfully created new trainer " + trainer.get().getName()
                    + " with id " + trainer.get().getId(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Could not create trainer", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/getrequests",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RequestWorkout>> getRequests(@RequestBody GetRequestsRequest getRequestsRequest){

        Optional<Trainer> trainer = authService.authenticateTrainer(getRequestsRequest.token());

        if(trainer.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(trainerService.getRequests(trainer.get().getId()), HttpStatus.OK);

    }

}