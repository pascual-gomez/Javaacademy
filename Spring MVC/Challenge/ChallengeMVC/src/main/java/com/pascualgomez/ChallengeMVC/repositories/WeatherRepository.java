package com.pascualgomez.ChallengeMVC.repositories;

import com.pascualgomez.ChallengeMVC.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
