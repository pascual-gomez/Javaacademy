package com.pascualgomez.Thesis.Controllers;

import com.pascualgomez.Thesis.DTOs.AddLabelDTO;
import com.pascualgomez.Thesis.DTOs.SendMessageDTO;
import com.pascualgomez.Thesis.Entities.Message;
import com.pascualgomez.Thesis.Repositories.LabelMessageRepository;
import com.pascualgomez.Thesis.Services.LabelService;
import com.pascualgomez.Thesis.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    LabelService labelService;

    @PostMapping("/send")
    public ResponseEntity send(@Valid @RequestBody SendMessageDTO sendMessageDTO,
                               BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity("Some fields are empty", HttpStatus.BAD_REQUEST);
        }

        try {
            messageService.sendMessage(sendMessageDTO);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(sendMessageDTO, HttpStatus.CREATED);
    }

    @GetMapping("/sent")
    public ResponseEntity<List<Message>> sent() {
        return new ResponseEntity(messageService.getSent(), HttpStatus.OK);
    }

    @GetMapping("/inbox")
    public ResponseEntity<List<Message>> inbox() {
        return new ResponseEntity(messageService.getSent(), HttpStatus.OK);
    }

    @PutMapping ("/label")
    public ResponseEntity addLabel(@Valid @RequestBody AddLabelDTO addLabelDTO,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity("Some fields are empty", HttpStatus.BAD_REQUEST);
        }

        try {
            labelService.addLabel(addLabelDTO);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(addLabelDTO, HttpStatus.CREATED);
    }
}
