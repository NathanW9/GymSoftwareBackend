package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.*;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<GymUser, Long> {

    GymUser save(GymUser gymUser);

    Optional<GymUser> findById(long id);

}
