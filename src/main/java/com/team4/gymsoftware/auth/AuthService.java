package com.team4.gymsoftware.auth;

import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.dto.LoginRequest;
import com.team4.gymsoftware.dto.LogoutRequest;

import java.util.Optional;

public interface AuthService {

    public Optional<String> loginUser(LoginRequest loginRequest);

    public Optional<String> loginTrainer(LoginRequest loginRequest);

    public Optional<GymUser> authenticateUser(String token);

    public Optional<Trainer> authenticateTrainer(String token);

    public Optional<String> logoutUser(LogoutRequest logoutRequest);

    public Optional<String> logoutTrainer(LogoutRequest logoutRequest);

}
