package com.team4.gymsoftware.scheduled;

import com.team4.gymsoftware.db.repositories.AuthSessionTrainerRepository;
import com.team4.gymsoftware.db.repositories.AuthSessionUserRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ShutdownTasks {

    private final AuthSessionUserRepository authSessionUserRepository;
    private final AuthSessionTrainerRepository authSessionTrainerRepository;

    public ShutdownTasks(AuthSessionUserRepository authSessionUserRepository,
                         AuthSessionTrainerRepository authSessionTrainerRepository){
        this.authSessionUserRepository = authSessionUserRepository;
        this.authSessionTrainerRepository = authSessionTrainerRepository;
    }

    @PreDestroy
    public void clearActiveSessions(){
        authSessionUserRepository.deleteAll();
        authSessionTrainerRepository.deleteAll();
        System.out.println("Cleared all active sessions");
    }

}
