package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.AuthSessionTrainer;
import com.team4.gymsoftware.db.models.AuthSessionUser;
import com.team4.gymsoftware.db.models.Trainer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AuthSessionTrainerRepository extends Repository<AuthSessionTrainer, Long> {

    AuthSessionTrainer save(AuthSessionTrainer authSessionTrainr);

    Optional<AuthSessionTrainer> findById(long id);

    Optional<AuthSessionTrainer> findByToken(String token);

    @Transactional
    @Query("select id from AuthSessionTrainer where trainer=:trainer")
    Optional<String> findByTrainer(Trainer trainer);

    @Modifying
    @Transactional
    @Query("delete from AuthSessionTrainer s where s.id=:id")
    void deleteById(long id);

    @Transactional
    @Modifying
    @Query("delete from AuthSessionTrainer")
    void deleteAll();

}
