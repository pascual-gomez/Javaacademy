package com.pascualgomez.dto;

import java.util.Date;

public class AddWeatherForm {

    private Date date;

    //Location
    private float latitude;
    private float longitude;
    private String city;
    private String state;

    //Temperature
    private float temp1;
    private float temp2;
    private float temp3;
    private float temp4;

    public AddWeatherForm(Date date, float latitude, float longitude,
                          String city, String state, float temp1, float temp2,
                          float temp3, float temp4) {
        super();
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
        this.temp4 = temp4;
    }

    public AddWeatherForm() {
        super();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
