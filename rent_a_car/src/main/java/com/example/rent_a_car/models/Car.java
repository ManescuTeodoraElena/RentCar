package com.example.rent_a_car.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")

public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 200)
    private String brand;
    @Column(nullable = false, length = 200)
    private String model;
    @Column(nullable = false)
    private double price;
    @Column(length = 50)
    private String color;
    @Enumerated(EnumType.STRING)
    private CarType carType;

    public Car(){}

    public Car(String brand, String model, double price, String color, CarType carType) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
        this.carType = carType;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

}
