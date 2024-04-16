package com.team4.gymsoftware.security;

import java.util.Map;
import com.team4.gymsoftware.db.models.GymUser;

public interface JwtGeneratorInterface {

    Map<String, String> generateToken(GymUser user);

}
