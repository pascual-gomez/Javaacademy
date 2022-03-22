package com.pascualgomez.controllers;

import com.pascualgomez.dto.AddWeatherForm;
import com.pascualgomez.entities.*;
import com.pascualgomez.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
        //model.addAttribute("weathers", weatherRepository.findAll());
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
        //Pass tables to the model
        model.addAttribute("weathers", weatherRepository.findAll());

        //Instantiate new objects
        Location location = new Location(values.getLatitude(), values.getLongitude(),
                values.getCity(), values.getState());
        Temperature temperature = new Temperature(values.getTemp1(), values.getTemp2(),
                values.getTemp3(), values.getTemp4());
        Weather weather = new Weather(values.getDate(), location, temperature);

        //Set location and temperature to weather object
        weather.setLocation(location);
        weather.setTemperature(temperature);

        //Save all objects on their tables
        weatherRepository.save(weather);
        locationRepository.save(location);
        temperatureRepository.save(temperature);

        return "weather";
    }


}
