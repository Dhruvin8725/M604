package com.carrental.system;

import com.carrental.system.model.Car;
import com.carrental.system.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedData(CarRepository carRepository) {
        return args -> {
            // Check if the database is empty
            if (carRepository.count() == 0) {
                System.out.println("Database is empty. Seeding initial data...");
                carRepository.save(new Car("Toyota", "Corolla", 2022, true));
                carRepository.save(new Car("Honda", "Civic", 2023, true));
                carRepository.save(new Car("Ford", "Mustang", 2021, false));
                carRepository.save(new Car("Suzuki", "Alto", 2024, true));
                System.out.println("Data seeding complete!");
            } else {
                System.out.println("Data already exists in the database. Skipping seed.");
            }
        };
    }
}