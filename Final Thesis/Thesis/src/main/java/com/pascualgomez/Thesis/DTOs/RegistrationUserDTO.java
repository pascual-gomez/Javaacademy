package com.pascualgomez.Thesis.DTOs;

import com.pascualgomez.Thesis.Annotations.PasswordMatches;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@PasswordMatches
public class RegistrationUserDTO {
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String matchingPassword;
    private String idNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String zipCode;
    private String state;
    private String country;
}
