package com.team4.gymsoftware.db.repositories;

import org.springframework.data.repository.Repository;
import com.team4.gymsoftware.db.models.*;

import java.util.Optional;

public interface WorkoutRepository extends Repository<Workout, Long> {

    Workout save(Workout workout);

    Optional<Workout> findById(long id);

    Optional<Workout> findByNameAndGymUser(String name, GymUser gymUser);

}
