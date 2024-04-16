package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.AuthSessionTrainer;
import com.team4.gymsoftware.db.models.AuthSessionUser;
import com.team4.gymsoftware.db.models.GymUser;
import jakarta.annotation.PreDestroy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AuthSessionUserRepository extends Repository<AuthSessionTrainer, Long> {

    AuthSessionUser save(AuthSessionUser authSessionUser);

    Optional<AuthSessionUser> findById(long id);

    @Transactional
    @Query("select id from AuthSessionUser where user=:user")
    Optional<String> findByUser(GymUser user);

    @Transactional
    @Modifying
    @Query("delete from AuthSessionUser")
    void deleteAll();

}
