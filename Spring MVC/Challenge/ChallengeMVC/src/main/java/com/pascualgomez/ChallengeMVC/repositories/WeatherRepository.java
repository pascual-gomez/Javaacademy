package com.pascualgomez.ChallengeMVC.repositories;

import com.pascualgomez.ChallengeMVC.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    @Override
    Optional<Weather> findById(Integer integer);
}
