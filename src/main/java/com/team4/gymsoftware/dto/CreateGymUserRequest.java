package com.team4.gymsoftware.dto;

import jakarta.annotation.Nullable;

public record CreateGymUserRequest(String name,
                                   String password,
                                   @Nullable Long trainer_id) {
}
