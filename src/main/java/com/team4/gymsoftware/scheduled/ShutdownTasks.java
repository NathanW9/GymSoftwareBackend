package com.team4.gymsoftware.scheduled;

import com.team4.gymsoftware.db.repositories.AuthSessionUserRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ShutdownTasks {

    private final AuthSessionUserRepository authSessionUserRepository;

    public ShutdownTasks(AuthSessionUserRepository authSessionUserRepository){
        this.authSessionUserRepository = authSessionUserRepository;
    }

    @PreDestroy
    public void clearActiveSessions(){
        authSessionUserRepository.deleteAll();
        System.out.println("Cleared all active sessions");
    }

}
