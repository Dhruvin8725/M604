package com.carrental.system.controller;

import com.carrental.system.model.Car;
import com.carrental.system.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    // CREATE: Add a new car
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    // READ: Get all cars
    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // READ: Get a specific car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE: Update a car's details (e.g., mark as rented)
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car existingCar = optionalCar.get();
            existingCar.setMake(carDetails.getMake());
            existingCar.setModel(carDetails.getModel());
            existingCar.setYear(carDetails.getYear());
            existingCar.setAvailable(carDetails.isAvailable());
            return ResponseEntity.ok(carRepository.save(existingCar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Remove a car from the fleet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}