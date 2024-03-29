package com.team4.gymsoftware.db.repositories;

import com.team4.gymsoftware.db.models.Admin;

import java.util.Optional;

public interface AdminRepository {

    Admin save(Admin admin);

    Optional<Admin> findById(long id);

}
