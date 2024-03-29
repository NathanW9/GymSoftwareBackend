package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.*;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RequestRepository extends Repository<Request, Long> {

    Request save(Request request);

    Optional<Request> findById(long id);

}
