package com.pascualgomez.repository;

import com.pascualgomez.entities.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
}
