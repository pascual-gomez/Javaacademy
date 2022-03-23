package com.pascualgomez.ChallengeMVC.controllers;

import com.pascualgomez.ChallengeMVC.dto.AddWeatherForm;
import com.pascualgomez.ChallengeMVC.entities.*;
import com.pascualgomez.ChallengeMVC.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RequestMapping("/weather")
@Controller
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    TemperatureRepository temperatureRepository;

    //Testing array - Not used in final implementation
    public static List<Weather> NEW_WEATHER = new ArrayList<>() {
        {
            add(new Weather(LocalDate.of(2020,Calendar.OCTOBER,21), new Location(0.001f,22.0f,"Medellin", "Antioquia"),
                    new Temperature(1,2,3,4)));
            add(new Weather(LocalDate.of(2020,Calendar.OCTOBER,21),
                    new Location(0.101f,22.0f,"Medellin", "Antioquia"),
                    new Temperature(1,22,3,3)));
        }
    };

    @GetMapping("/")
    public String getAll(Model model) {
        //Pass table to the model

        //model.addAttribute("weathers", NEW_WEATHER);
        model.addAttribute("weathers", weatherRepository.findAll());
        //Pass form to the model
        model.addAttribute("addWeatherForm", new AddWeatherForm());

        return "weather";
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
        //NEW_WEATHER.add(weather);

        //Pass tables to the model
        model.addAttribute("weathers", weatherRepository.findAll());
        //model.addAttribute("weathers", NEW_WEATHER);

        return "weather";
    }




}
