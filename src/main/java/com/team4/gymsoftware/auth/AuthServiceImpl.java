package com.team4.gymsoftware.auth;

import com.sun.jdi.request.DuplicateRequestException;
import com.team4.gymsoftware.db.models.AuthSessionUser;
import com.team4.gymsoftware.db.models.GymUser;
import com.team4.gymsoftware.db.models.Trainer;
import com.team4.gymsoftware.db.repositories.AuthSessionTrainerRepository;
import com.team4.gymsoftware.db.repositories.AuthSessionUserRepository;
import com.team4.gymsoftware.db.repositories.GymUserRepository;
import com.team4.gymsoftware.db.repositories.TrainerRepository;
import com.team4.gymsoftware.dto.LoginRequest;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService{

    private final GymUserRepository gymUserRepository;
    private final TrainerRepository trainerRepository;
    private final AuthSessionUserRepository authSessionUserRepository;
    private final AuthSessionTrainerRepository authSessionTrainerRepository;

    AuthServiceImpl(GymUserRepository gymUserRepository,
                    TrainerRepository trainerRepository,
                    AuthSessionUserRepository authSessionUserRepository,
                    AuthSessionTrainerRepository authSessionTrainerRepository){
        this.gymUserRepository = gymUserRepository;
        this.trainerRepository = trainerRepository;
        this.authSessionUserRepository = authSessionUserRepository;
        this.authSessionTrainerRepository = authSessionTrainerRepository;
    }

    @Override
    public Optional<String> loginUser(LoginRequest loginRequest) {

        Random r = new Random();

        String username = loginRequest.username();
        String password = loginRequest.password();

        if(username == null || password == null){
            throw new IllegalArgumentException();
        }

        Optional<GymUser> user = gymUserRepository.
                findByNameAndPassword(username, password);

        if(user.isEmpty()){
            return Optional.empty();
        }

        if(authSessionUserRepository.findByUser(user.get()).isPresent()){
            throw new DuplicateRequestException();
        }

        AuthSessionUser newSession = new AuthSessionUser();
        newSession.setUser(user.get());
        newSession.setStarted(Instant.now());

        String token = "";

        for(int ndx = 0; ndx < 5; ndx++){
            token = token.concat(String.valueOf((char)(r.nextInt(26) + 'a')));
        }

        for(int ndx = 0; ndx < 5; ndx++){
            token = token.concat(String.valueOf(r.nextInt(26)));
        }

        newSession.setToken("" + user.get().getName() + "_" + token);

        return Optional.of(authSessionUserRepository.save(newSession).getToken());

    }

    @Override
    public Optional<String> loginTrainer(LoginRequest loginRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<GymUser> authenticateUser(String token) {
        return Optional.empty();
    }

    @Override
    public Optional<Trainer> authenticateTrainer(String token) {
        return Optional.empty();
    }

}
