package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.*;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RequestWorkoutRepository extends Repository<Request, Long> {

    RequestWorkout save(RequestWorkout workoutRequest);

    Optional<RequestWorkout> findUserById(Long id);



}