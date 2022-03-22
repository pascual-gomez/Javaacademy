package com.pascualgomez.entities;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private float latitude;

    @Column
    private float longitude;

    @Column
    private String city;

    @Column
    private String state;

    @OneToOne
    @JoinColumn(name = "weather_id")
    private Weather weather;

    public Location() {};

    public Location(float latitude, float longitude, String city, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
