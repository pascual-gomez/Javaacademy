package com.pascualgomez.Thesis.Services;

import com.pascualgomez.Thesis.DTOs.AddLabelDTO;
import com.pascualgomez.Thesis.DTOs.FilterLabelDTO;
import com.pascualgomez.Thesis.Entities.LabelMessage;
import com.pascualgomez.Thesis.Entities.Message;
import com.pascualgomez.Thesis.Entities.User;
import com.pascualgomez.Thesis.Exceptions.NotFoundMessageException;
import com.pascualgomez.Thesis.Repositories.LabelMessageRepository;
import com.pascualgomez.Thesis.Repositories.MessageRepository;
import com.pascualgomez.Thesis.Repositories.UserRepository;
import com.pascualgomez.Thesis.Singleton.LoggedContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LabelService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LabelMessageRepository labelMessageRepository;

    @Autowired
    MessageRepository messageRepository;

    public AddLabelDTO addLabel(AddLabelDTO addLabelDTO) throws RuntimeException {

        Long id_message = Long.parseLong(addLabelDTO.getIdMessage());
        Message message = messageRepository.getById(id_message);
        Optional<User> userContext = userRepository
                .findByUsername(LoggedContext.getInstance().getLoggedUsername());
        User user = userContext.get();

        if (message.equals(null)) {
            throw new NotFoundMessageException(id_message);
        }

        LabelMessage labelToSave = LabelMessage.builder()
                .label(addLabelDTO.getLabel())
                .message(message)
                .user(user)
                .build();

        labelMessageRepository.save(labelToSave);

        List<LabelMessage> toSetMessage = message.getLabelMessage();
        toSetMessage.add(labelToSave);
        message.setLabelMessage(toSetMessage);
        messageRepository.save(message);

        List<LabelMessage> toSetUser = user.getLabels();
        toSetUser.add(labelToSave);
        user.setLabels(toSetUser);
        userRepository.save(user);

        return addLabelDTO;
    }

    public List<Message> filterLabel(FilterLabelDTO filterLabelDTO) throws RuntimeException {
        User user = userRepository.
                findByUsername(LoggedContext.getInstance().getLoggedUsername()).get();

        List<Message> messages = new ArrayList<Message>();
        labelMessageRepository.findAllByLabelAndUser(filterLabelDTO.getLabel(), user)
                .forEach(labelMessage -> messages.add(labelMessage.getMessage()));
        
        return messages;
    }
}
