package com.pascualgomez.ChallengeMVC.dto;

public class UpdateWeatherForm {

    private int id;

    //Date
    private int year;
    private int month;
    private int day;

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

    public UpdateWeatherForm(int year, int month, int day, float latitude, float longitude,
                          String city, String state, float temp1, float temp2,
                          float temp3, float temp4) {
        super();
        this.year = year;
        this. month = month;
        this.day = day;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
        this.temp4 = temp4;
    }

    public UpdateWeatherForm() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
