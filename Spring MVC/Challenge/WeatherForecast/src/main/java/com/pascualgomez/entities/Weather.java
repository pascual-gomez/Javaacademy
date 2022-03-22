package com.pascualgomez.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToOne(mappedBy = "location")
    private Location location;

    @OneToOne(mappedBy = "temperature")
    private Temperature temperature;

    public Weather(Date date, Location location, Temperature temperature) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
