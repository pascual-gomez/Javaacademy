package com.pascualgomez.Thesis.Repositories;

import com.pascualgomez.Thesis.Entities.LabelMessage;
import com.pascualgomez.Thesis.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LabelMessageRepository extends JpaRepository<LabelMessage, Long> {

    Optional<LabelMessage> findByLabel(String label);

    Iterable<LabelMessage> findAllByLabelAndUser(String label, User user);
}
