package com.team4.gymsoftware.dto;

import java.time.Instant;

public record RequestWorkoutRequest(long trainer_id,
                                    long user_id,
                                    String title,
                                    String description,
                                    Instant sent) {
                                        
                                    }
