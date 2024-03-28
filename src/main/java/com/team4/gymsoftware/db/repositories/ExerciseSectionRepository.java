package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.*;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ExerciseSectionRepository extends Repository<ExerciseSection, Long> {

    ExerciseSection save(ExerciseSection exerciseSection);

    Optional<ExerciseSection> findById(long id);

}
