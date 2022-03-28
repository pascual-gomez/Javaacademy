package com.pascualgomez.ChallengeREST.repositories;

import com.pascualgomez.ChallengeREST.entitites.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}