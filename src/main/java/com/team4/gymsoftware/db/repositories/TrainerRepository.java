package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.Trainer;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface TrainerRepository extends Repository<Trainer, Long> {

    Trainer save(Trainer trainer);

    Optional<Trainer> findById(long id);

}
