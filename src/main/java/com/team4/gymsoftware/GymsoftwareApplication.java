package com.team4.gymsoftware;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.team4.gymsoftware.db.models.*;
import com.team4.gymsoftware.db.repositories.*;

import java.util.NoSuchElementException;


@SpringBootApplication
public class GymsoftwareApplication {

	public static void main(String[] args) {

		SpringApplication.run(GymsoftwareApplication.class, args);

	}

}
