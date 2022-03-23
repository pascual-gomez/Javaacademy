package com.pascualgomez.ChallengeMVC.repositories;

import com.pascualgomez.ChallengeMVC.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
