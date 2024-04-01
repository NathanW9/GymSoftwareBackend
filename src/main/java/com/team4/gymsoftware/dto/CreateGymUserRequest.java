package com.team4.gymsoftware.dto;

import jakarta.annotation.Nullable;

public record CreateGymUserRequest(String name,
                                   @Nullable Long trainer_id) {
}
