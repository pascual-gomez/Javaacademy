package com.pascualgomez.ChallengeMVC.controllers;

import com.pascualgomez.ChallengeMVC.dto.AddWeatherForm;
import com.pascualgomez.ChallengeMVC.dto.UpdateWeatherForm;
import com.pascualgomez.ChallengeMVC.entities.*;
import com.pascualgomez.ChallengeMVC.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;


@RequestMapping("/weather")
@Controller
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    TemperatureRepository temperatureRepository;


    @GetMapping("/")
    public String getAll(Model model) {
        //Pass table to the model
        model.addAttribute("weathers", weatherRepository.findAll());

        //Pass form to the model
        model.addAttribute("addWeatherForm", new AddWeatherForm());

        return "weather";
    }

    @GetMapping("/edit")
    public String updateView(Model model) {

        model.addAttribute("updateWeatherForm", new UpdateWeatherForm());

        return "update";
    }

    @PostMapping("/add")
    public String submit(@ModelAttribute("addWeatherForm") AddWeatherForm values,
                         BindingResult result, ModelMap model) {

        //If any error, return error
        if (result.hasErrors()) {
            return "error";
        }

        //Instantiate new objects
        Location location = new Location(values.getLatitude(), values.getLongitude(),
                values.getCity(), values.getState());
        Temperature temperature = new Temperature(values.getTemp1(), values.getTemp2(),
                values.getTemp3(), values.getTemp4());
        Weather weather = new Weather();

        //Save all objects on their tables
        locationRepository.save(location);
        temperatureRepository.save(temperature);

        //Assign temperature and location to weather
        weather.setLocation(location);
        weather.setTemperature(temperature);
        weather.setDate(LocalDate.of(values.getYear(), values.getMonth(), values.getDay()));

        weatherRepository.save(weather);

        //Pass tables to the model
        model.addAttribute("weathers", weatherRepository.findAll());

        return "weather";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("updateWeatherForm") UpdateWeatherForm values,
                         BindingResult result, ModelMap model) {

        //If any error, return error
        if (result.hasErrors()) {
            return "error";
        }

        int id = values.getId();

        Optional<Weather> updateWeather = weatherRepository.findById(id);

        if (updateWeather.isPresent()) {

            Weather weather = updateWeather.get();
            Location location = weather.getLocation();
            Temperature temperature = weather.getTemperature();

            //Set new values
            location.setLatitude(values.getLatitude());
            location.setLongitude(values.getLongitude());
            location.setCity(values.getCity());
            location.setState(values.getState());

            temperature.setTemp1(values.getTemp1());
            temperature.setTemp2(values.getTemp2());
            temperature.setTemp3(values.getTemp3());
            temperature.setTemp4(values.getTemp4());

            //Save all objects on their tables
            locationRepository.save(location);
            temperatureRepository.save(temperature);

            //Assign temperature and location to weather
            //weather.setLocation(location);
            //weather.setTemperature(temperature);
            weather.setDate(LocalDate.of(values.getYear(), values.getMonth(), values.getDay()));

            //Save weather
            weatherRepository.save(weather);

            //Pass tables to the model
            model.addAttribute("weathers", weatherRepository.findAll());
            model.addAttribute("addWeatherForm", new AddWeatherForm());

            return "weather";
        }

        return "error";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {

        //Get object with id
        Optional<Weather> updateWeather = weatherRepository.findById(id);

        //Check if object was found
        if (updateWeather.isPresent()) {

            Weather weather = updateWeather.get();

            //Delete objects
            weatherRepository.delete(weather);
            locationRepository.delete(weather.getLocation());
            temperatureRepository.delete(weather.getTemperature());

            //Pass parameters to view
            model.addAttribute("weathers", weatherRepository.findAll());
            model.addAttribute("addWeatherForm", new AddWeatherForm());

            return "weather";
        }

        return "error";
    }


}
