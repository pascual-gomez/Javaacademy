package com.pascualgomez.ChallengeMVC.repositories;


import com.pascualgomez.ChallengeMVC.entities.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
}
