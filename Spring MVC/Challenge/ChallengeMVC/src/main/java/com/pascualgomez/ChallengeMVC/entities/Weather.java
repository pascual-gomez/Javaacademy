package com.pascualgomez.ChallengeMVC.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToOne
    @JoinColumn(name = "temperature_id", referencedColumnName = "id")
    private Temperature temperature;

    public Weather(LocalDate date, Location location, Temperature temperature) {
        this.date = date;
        this.location = location;
        this.temperature = temperature;
    }

    public Weather() {}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }


}
