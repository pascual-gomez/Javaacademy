package com.pascualgomez.Thesis.Controllers;

import com.pascualgomez.Thesis.DTOs.LoginUserDTO;
import com.pascualgomez.Thesis.Services.UserService;
import com.pascualgomez.Thesis.Singleton.LoggedContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginUserDTO loginUserDto,
                                BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity("Some fields are empty", HttpStatus.BAD_REQUEST);
        }

        try {
            userService.loginUser(loginUserDto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        System.out.println(LoggedContext.getInstance().getLoggedUsername());
        return new ResponseEntity("You have logged in successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {

        try {
            userService.logOut();
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("You have logged out successfully!", HttpStatus.CREATED);
    }

}
