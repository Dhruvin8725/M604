package com.carrental.system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private int year;
    private boolean isAvailable;

    // Constructors
    public Car() {}

    public Car(String make, String model, int year, boolean isAvailable) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}