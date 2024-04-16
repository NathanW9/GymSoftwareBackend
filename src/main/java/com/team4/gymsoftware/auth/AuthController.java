package com.team4.gymsoftware.auth;

import com.sun.jdi.request.DuplicateRequestException;
import com.team4.gymsoftware.dto.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.InstanceAlreadyExistsException;
import java.util.Optional;

@Controller
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/loginuser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        Optional<String> token = null;

        try {
            token = authService.loginUser(loginRequest);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Login credentials not provided", HttpStatus.BAD_REQUEST);
        } catch (DuplicateRequestException e){
            return new ResponseEntity<>("Session is already active for user", HttpStatus.BAD_REQUEST);
        }

        if (token.isEmpty()) {
            return new ResponseEntity<>("Invalid login credentials", HttpStatus.UNAUTHORIZED);

        }

        return new ResponseEntity<>(token.get(), HttpStatus.OK);

    }
}
