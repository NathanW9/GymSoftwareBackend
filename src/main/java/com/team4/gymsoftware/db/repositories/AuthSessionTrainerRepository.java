package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.AuthSessionTrainer;
import org.springframework.data.repository.Repository;
import java.util.Optional;

public interface AuthSessionTrainerRepository extends Repository<AuthSessionTrainer, Long> {

    AuthSessionTrainer save(AuthSessionTrainer authSessionTrainr);

    Optional<AuthSessionTrainer> findById(long id);

}
