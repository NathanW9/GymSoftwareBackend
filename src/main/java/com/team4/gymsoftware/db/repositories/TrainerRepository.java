package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends Repository<Trainer, Long> {

    Trainer save(Trainer trainer);

    Optional<Trainer> findById(long id);

    Optional<Trainer> findByName(String name);

    Optional<Trainer> findByNameAndPassword(String name, String password);

    List<Trainer> findAll();

}
