package com.pascualgomez.Thesis.Repositories;

import com.pascualgomez.Thesis.Entities.LabelMessage;
import com.pascualgomez.Thesis.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MessageRepository extends JpaRepository<Message, Long> {

    @Override
    default Message getById(Long id) {
        return null;
    }
}
