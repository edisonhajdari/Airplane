package com.example.aeroplanirest.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
@Entity
@Table(name = "airplanes")
public class Airplane {

    @Id
    private Long id;
    private String name;
    private String manufacturer;
    private int year;
    private String origin;
    private int seats;
    private String destination;
    private String model;

    public Airplane() {
    }

    public Airplane(Long id, String name, String manufacturer, int year, String origin, int seats, String destination, String model) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
        this.origin = origin;
        this.seats = seats;
        this.destination = destination;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
