package com.team4.gymsoftware.dto;

import java.time.Instant;

public record RequestWorkoutRequest(String token,
                                    long trainer_id,
                                    String title,
                                    String description,
                                    Instant sent) {
                                        
                                    }
