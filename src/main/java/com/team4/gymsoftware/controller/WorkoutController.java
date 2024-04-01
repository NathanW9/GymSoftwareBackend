package com.team4.gymsoftware.controller;

import com.team4.gymsoftware.db.models.*;
import com.team4.gymsoftware.dto.CreateWorkoutRequest;
import com.team4.gymsoftware.dto.EditWorkoutRequest;
import com.team4.gymsoftware.services.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class WorkoutController {

    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping(path = "/createworkout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createWorkout(@RequestBody CreateWorkoutRequest createWorkoutRequest){

        try {
            Optional<Workout> savedWorkout = workoutService.saveWorkout(createWorkoutRequest);
            if(savedWorkout.isPresent()) {
                return new ResponseEntity<>("Created new workout " + savedWorkout.get().getName()
                        + " with id " + savedWorkout.get().getId(), HttpStatus.OK);
            }
            return new ResponseEntity<>("Could not create workout: workout already exists", HttpStatus.BAD_REQUEST);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>("Could not create workout: malformed request (" + e.getMessage() + ")", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/editworkout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> editWorkout(@RequestBody EditWorkoutRequest editWorkoutRequest){

        try{

            Optional<Workout> editedWorkout = workoutService.patchWorkout(editWorkoutRequest);
            if(editedWorkout.isPresent()) {
                return new ResponseEntity<>("Successfully edited workout " + editedWorkout.get().getName()
                + " for user with id " + editedWorkout.get().getGymUser().getId(), HttpStatus.OK);
            }
            return new ResponseEntity<>("Could not edit workout: workout does not exist", HttpStatus.BAD_REQUEST);

        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>("Could not edit workout: malformed request (" + e.getMessage() + ")", HttpStatus.BAD_REQUEST);
        }

    }

}
