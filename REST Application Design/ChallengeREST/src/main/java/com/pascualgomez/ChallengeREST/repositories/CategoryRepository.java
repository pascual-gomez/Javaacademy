package com.pascualgomez.ChallengeREST.repositories;

import com.pascualgomez.ChallengeREST.entitites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
