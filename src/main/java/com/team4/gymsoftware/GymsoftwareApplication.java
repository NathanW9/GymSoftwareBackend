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

	@Bean
	CommandLineRunner runner(GymUserRepository gymUserRepository,
							 TrainerRepository trainerRepository,
							 RequestRepository requestRepository) {
		return args -> {

			GymUser gymUser = new GymUser();
			gymUser.setName("John");

			gymUserRepository.save(gymUser);
			GymUser savedUser = gymUserRepository.findById(gymUser.getId()).orElseThrow(NoSuchElementException::new);

			Trainer trainer = new Trainer();
			trainer.setName("Joe");

			trainerRepository.save(trainer);
			Trainer savedTrainer = trainerRepository.findById(trainer.getId()).orElseThrow(NoSuchElementException::new);

			savedUser.setTrainer(savedTrainer);
			gymUserRepository.save(savedUser);

			Request request = new Request();
			request.setRequester(savedUser);
			request.setReceiver(savedTrainer);

			requestRepository.save(request);
		};
	}

}
