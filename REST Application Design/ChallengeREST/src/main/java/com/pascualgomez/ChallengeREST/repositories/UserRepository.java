package com.pascualgomez.ChallengeREST.repositories;

import com.pascualgomez.ChallengeREST.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}