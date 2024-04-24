package com.team4.gymsoftware.controller;

import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.models.Workout;
import com.team4.gymsoftware.dto.CreateTrainerRequest;
import com.team4.gymsoftware.dto.RequestWorkoutRequest;
import com.team4.gymsoftware.services.TrainerService;
import com.team4.gymsoftware.services.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TrainerController {

    private TrainerService trainerService;
    private WorkoutService workoutService;

    public TrainerController(TrainerService trainerService, WorkoutService workoutService) {
        this.trainerService = trainerService;
        this.workoutService = workoutService;
    }

    @PostMapping(path = "/registertrainer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createTrainer(@RequestBody CreateTrainerRequest createTrainerRequest){

        Optional<Trainer> trainer = trainerService.saveTrainer(createTrainerRequest);

        if(trainer.isPresent()){
            return new ResponseEntity<>("Successfully created new trainer " + trainer.get().getName()
                    + " with id " + trainer.get().getId(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Could not create trainer", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/createworkout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createWorkoutFromRequest(@RequestBody RequestWorkoutRequest requestWorkoutRequest) {
        Optional<Workout> createdWorkout = trainerService.createWorkoutFromRequest(requestWorkoutRequest);

        if (createdWorkout.isPresent()) {
            return new ResponseEntity<>("Workout created successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to create workout", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/assignUserWorkout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> assignUserWorkout(@RequestBody RequestWorkoutRequest requestWorkoutRequest) {
        Optional<Workout> createdWorkout = workoutService.assignUserWorkout(requestWorkoutRequest);

        if (createdWorkout.isPresent()) {
            return new ResponseEntity<>("Workout assigned to user successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to assign workout to user", HttpStatus.BAD_REQUEST);
        }
    }