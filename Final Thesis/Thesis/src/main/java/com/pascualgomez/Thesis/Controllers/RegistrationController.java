package com.pascualgomez.Thesis.Controllers;

import com.pascualgomez.Thesis.DTOs.RegistrationUserDTO;
import com.pascualgomez.Thesis.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationUserDTO registerUserDto,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity("Some fields are empty", HttpStatus.BAD_REQUEST);
        }
        try {
            userService.saveUser(registerUserDto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("You have signed up successfully!", HttpStatus.CREATED);
    }
}
