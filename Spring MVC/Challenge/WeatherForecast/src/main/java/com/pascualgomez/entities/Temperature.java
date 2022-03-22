package com.pascualgomez.entities;

import javax.persistence.*;

@Entity
@Table(name = "temperature")
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column
    private float temp1;

    @Column
    private float temp2;

    @Column
    private float temp3;

    @Column
    private float temp4;

    @OneToOne
    @JoinColumn(name = "weather_id")
    private Weather weather;

    public Temperature() {}

    public Temperature(float temp1, float temp2, float temp3, float temp4) {
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
        this.temp4 = temp4;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public float getTemp1() {
        return temp1;
    }

    public void setTemp1(float temp1) {
        this.temp1 = temp1;
    }

    public float getTemp2() {
        return temp2;
    }

    public void setTemp2(float temp2) {
        this.temp2 = temp2;
    }

    public float getTemp3() {
        return temp3;
    }

    public void setTemp3(float temp3) {
        this.temp3 = temp3;
    }

    public float getTemp4() {
        return temp4;
    }

    public void setTemp4(float temp4) {
        this.temp4 = temp4;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}

