package com.pascualgomez.Thesis.Services;

import com.pascualgomez.Thesis.DTOs.SendMessageDTO;
import com.pascualgomez.Thesis.Entities.Message;
import com.pascualgomez.Thesis.Entities.MessageReceivers;
import com.pascualgomez.Thesis.Entities.User;
import com.pascualgomez.Thesis.Repositories.LabelMessageRepository;
import com.pascualgomez.Thesis.Repositories.MessageReceiversRepository;
import com.pascualgomez.Thesis.Repositories.MessageRepository;
import com.pascualgomez.Thesis.Repositories.UserRepository;
import com.pascualgomez.Thesis.Singleton.LoggedContext;
import com.pascualgomez.Thesis.Singleton.TypeReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@Transactional
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageReceiversRepository messageReceiversRepository;

    @Autowired
    LabelMessageRepository labelMessageRepository;

    public SendMessageDTO sendMessage(SendMessageDTO sendMessageDTO) throws RuntimeException {

        System.out.println();
        Optional<User> sender = userRepository
                .findByUsername(LoggedContext.getInstance().getLoggedUsername());

        Message messageToSave = Message.builder()
                .subject(sendMessageDTO.getSubject())
                .body(sendMessageDTO.getBody())
                .attachment(sendMessageDTO.getAttachment())
                .sender(sender.get())
                .build();
        System.out.println("CREATED MESSAGE");
        List<MessageReceivers> sendTo = new ArrayList<>();

        if (sendMessageDTO.getSendTo() != null) {
            List<String> usernamesToSend = sendMessageDTO.getSendTo();
            for (String username:usernamesToSend) {
                User receiver = userRepository.findByUsername(username).get();
                System.out.println(receiver.toString());
                MessageReceivers toSave = new MessageReceivers()
                        .builder()
                        .message(messageToSave)
                        .receiver(receiver)
                        .typeReceiver(TypeReceiver.TO)
                        .build();

                messageReceiversRepository.save(toSave);
                sendTo.add(toSave);
                List<MessageReceivers> toSetUser = receiver.getReceivedMessages();
                toSetUser.add(toSave);
                receiver.setReceivedMessages(toSetUser);
                userRepository.save(receiver);
            }
        }
        System.out.println("FIRST IF PASSED");
        if (sendMessageDTO.getSendCopy() != null) {
            List<String> usernamesToCopy = sendMessageDTO.getSendCopy();
            for (String username:usernamesToCopy) {
                User receiver = userRepository.findByUsername(username).get();
                MessageReceivers toSave = new MessageReceivers()
                        .builder()
                        .message(messageToSave)
                        .receiver(receiver)
                        .typeReceiver(TypeReceiver.CC)
                        .build();

                messageReceiversRepository.save(toSave);
                sendTo.add(toSave);
                List<MessageReceivers> toSetUser = receiver.getReceivedMessages();
                toSetUser.add(toSave);
                receiver.setReceivedMessages(toSetUser);
                userRepository.save(receiver);
            }
        }
        System.out.println("SECOND IF PASSED");
        if (sendMessageDTO.getSendBlindCopy() != null) {
            List<String> usernamesToBlind = sendMessageDTO.getSendBlindCopy();
            for (String username:usernamesToBlind) {
                User receiver = userRepository.findByUsername(username).get();
                MessageReceivers toSave = new MessageReceivers()
                        .builder()
                        .message(messageToSave)
                        .receiver(receiver)
                        .message(messageToSave)
                        .typeReceiver(TypeReceiver.BCC)
                        .build();

                messageReceiversRepository.save(toSave);
                sendTo.add(toSave);
                List<MessageReceivers> toSetUser = receiver.getReceivedMessages();
                toSetUser.add(toSave);
                receiver.setReceivedMessages(toSetUser);
                userRepository.save(receiver);
            }
        }
        System.out.println("THIRD IF PASSED");
        messageToSave.setReceivers(sendTo);
        System.out.println("BEFORE SAVE");
        messageRepository.save(messageToSave);


        return sendMessageDTO;

    }


    public List<Message> getSent() {
        List<Long> messages = new ArrayList<>();
        User user = userRepository.
                findByUsername(LoggedContext.getInstance().getLoggedUsername()).get();

        return user.getSentMessages();
    }

    public List<Message> getReceived() {
        List<Long> messages = new ArrayList<>();
        User user = userRepository.
                findByUsername(LoggedContext.getInstance().getLoggedUsername()).get();
        List<Message> receivedMessages = new ArrayList<>();
        user.getReceivedMessages().forEach(msgRcv -> receivedMessages.add(msgRcv.getMessage()));

        return receivedMessages;
    }
}
