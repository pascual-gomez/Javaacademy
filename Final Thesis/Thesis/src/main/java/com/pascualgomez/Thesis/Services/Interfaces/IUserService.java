package com.pascualgomez.Thesis.Services.Interfaces;

import com.pascualgomez.Thesis.DTOs.RegistrationUserDTO;

public interface IUserService {
    public RegistrationUserDTO saveUser(RegistrationUserDTO regUserDto) throws Exception;
}
