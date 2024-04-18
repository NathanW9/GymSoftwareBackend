package com.team4.gymsoftware.dto;

public record RequestWorkoutRequest(long trainer_id, 
                                    long user_id, 
                                    String workout_type, 
                                    String workout_bodyPart, 
                                    int workout_intensity, 
                                    String description, 
                                    Boolean workout_equipment
                                    Instant sent) {
                                        
                                    }
