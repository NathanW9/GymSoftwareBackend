package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ExerciseSectionRepository extends Repository<ExerciseSection, Long> {

    ExerciseSection save(ExerciseSection exerciseSection);

    Optional<ExerciseSection> findById(long id);

    Optional<ExerciseSection> findByWorkout(Workout workout);

    @Transactional
    @Modifying
    @Query("delete from ExerciseSection e where e.workout=:workout")
    void deleteByWorkout(@Param("workout") Workout workout);

}
