package com.team4.gymsoftware.services;

import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.dto.CreateGymUserRequest;

import java.util.Optional;

public interface GymUserService {

    public Optional<GymUser> saveGymUser(CreateGymUserRequest createGymUserRequest);

}
