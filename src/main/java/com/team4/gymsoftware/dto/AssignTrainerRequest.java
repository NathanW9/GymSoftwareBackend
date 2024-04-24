package com.team4.gymsoftware.dto;

public record AssignTrainerRequest(String token,
                                   long user_id,
                                   long trainer_id) {
}
