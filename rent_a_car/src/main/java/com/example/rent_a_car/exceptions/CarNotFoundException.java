package com.example.rent_a_car.exceptions;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
        super(message);
    }
}
