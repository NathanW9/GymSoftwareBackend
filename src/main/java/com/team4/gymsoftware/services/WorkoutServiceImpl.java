package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.ExerciseSection;
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

    private final ExerciseRepository exerciseRepository;
    private final ExerciseSectionRepository exerciseSectionRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository,
                              GymUserRepository gymUserRepository,
                              TrainerRepository trainerRepository,
                              ExerciseRepository exerciseRepository,
                              ExerciseSectionRepository exerciseSectionRepository){
        this.workoutRepository = workoutRepository;
        this.gymUserRepository = gymUserRepository;
        this.trainerRepository = trainerRepository;
        this.exerciseRepository = exerciseRepository;
        this.exerciseSectionRepository = exerciseSectionRepository;
    }

    @Override
    public Optional<Workout> saveWorkout(CreateWorkoutRequest createWorkoutRequest) {
        if(workoutRepository.findByNameAndGymUser(createWorkoutRequest.name(),
                gymUserRepository.findById(createWorkoutRequest.user_id()).orElseThrow()).isEmpty()){

            Workout workout = new Workout();
            workout.setName(createWorkoutRequest.name());
            workout.setTrainer(trainerRepository.findById(createWorkoutRequest.trainer_id()).orElseThrow());
            workout.setGymUser(gymUserRepository.findById(createWorkoutRequest.user_id()).orElseThrow());

            workout = workoutRepository.save(workout);

            for(int ndx = 0; ndx < createWorkoutRequest.exercises().length; ndx++){

                ExerciseSection tempExerciseSection = new ExerciseSection();
                tempExerciseSection.setWorkout(workout);
                tempExerciseSection.setReps(createWorkoutRequest.exercises()[ndx].reps());
                tempExerciseSection.setSets(createWorkoutRequest.exercises()[ndx].sets());
                tempExerciseSection.setWeight(createWorkoutRequest.exercises()[ndx].weight());
                tempExerciseSection.setExercise(
                        exerciseRepository.findByName(createWorkoutRequest.exercises()[ndx].exercise()).orElseThrow()
                );

                exerciseSectionRepository.save(tempExerciseSection);

            }

            return Optional.of(workout);
        }
        return Optional.empty();
    }
}
