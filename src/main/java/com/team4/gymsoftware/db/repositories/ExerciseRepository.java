package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.*;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ExerciseRepository extends Repository<Exercise, Long> {

    Exercise save(Exercise exercise);

    Optional<Exercise> findById(long id);

}
