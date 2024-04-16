package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.AuthSessionUser;
import org.springframework.data.repository.Repository;
import java.util.Optional;

public interface AuthSessionTrainerRepository extends Repository<AuthSessionUser, Long> {

    AuthSessionUser save(AuthSessionUser authSessionUser);

    Optional<AuthSessionUser> findById(long id);

}
