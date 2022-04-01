package com.pascualgomez.Thesis.Repositories;

import com.pascualgomez.Thesis.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByNameRole(String nameRole);
}
