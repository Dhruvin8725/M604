package com.carrental.system.repository;

import com.carrental.system.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // You can add custom queries here later, like finding cars by make!
}