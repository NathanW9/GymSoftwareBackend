package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.*;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface RequestWorkoutRepository extends Repository<RequestWorkout, Long> {

    RequestWorkout save(RequestWorkout requestWorkout);

    Optional<RequestWorkout> findById(long id);

    List<RequestWorkout> findAllByTrainer(Trainer trainer);

}
