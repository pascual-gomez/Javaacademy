package com.pascualgomez.Thesis.Services;

import com.pascualgomez.Thesis.DTOs.LoginUserDTO;
import com.pascualgomez.Thesis.DTOs.RegistrationUserDTO;
import com.pascualgomez.Thesis.Entities.User;
import com.pascualgomez.Thesis.Exceptions.UserAlreadyExistException;
import com.pascualgomez.Thesis.Exceptions.UserNotFoundException;
import com.pascualgomez.Thesis.Repositories.RolesRepository;
import com.pascualgomez.Thesis.Repositories.UserRepository;
import com.pascualgomez.Thesis.Services.Interfaces.IUserService;
import com.pascualgomez.Thesis.Singleton.LoggedContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public User getUserByUsername(String username) throws RuntimeException {
        AtomicReference<User> user = new AtomicReference<User>();

        userRepository.findByUsername(username).
                ifPresentOrElse(foundUser -> user.set(foundUser), () -> {
            throw new UserNotFoundException(username);
        });

        return user.get();
    }

    public RegistrationUserDTO saveUser(RegistrationUserDTO regUserDTO) throws Exception {
        Optional<User> regUser = userRepository.
                findByUsername(regUserDTO.getUsername());

        if (regUser.isPresent()) {
            throw new UserAlreadyExistException(regUserDTO.getUsername());
        }

        User userToSave = User.builder()
                .username(regUserDTO.getUsername())
                .password(regUserDTO.getPassword())
                .name(regUserDTO.getFirstName())
                .lastName(regUserDTO.getLastName())
                .idNumber(regUserDTO.getIdNumber())
                .address(regUserDTO.getAddress())
                .zipCode(regUserDTO.getZipCode())
                .state(regUserDTO.getState())
                .country(regUserDTO.getCountry())
                .roles(rolesRepository.findByNameRole("STD").stream().toList())
                .enabled(true)
                .build();

        try {
            userRepository.save(userToSave);
        } catch (Exception e) {
            throw new Exception("User not saved: " + e.getMessage());
        }

        return regUserDTO;
    }

    public LoginUserDTO loginUser(LoginUserDTO loginUserDTO) throws Exception {

        Optional<User> user = userRepository.findByUsername(loginUserDTO.getUsername());

        if (!user.isPresent()) {
            throw new UserNotFoundException(loginUserDTO.getUsername());
        }

        if (!user.get().getPassword().equals(loginUserDTO.getPassword())) {
            throw new Exception("Username or password incorrect.");
        }

        LoggedContext.getInstance().setLoggedUsername(loginUserDTO.getUsername());

        return loginUserDTO;
    }

    public User logOut() throws Exception {
        if (LoggedContext.getInstance().getLoggedUsername().equals(null)) {
            throw new Exception("You need to log in first.");
        }

        Optional<User> user = userRepository.
                findByUsername(LoggedContext.getInstance().getLoggedUsername());

        LoggedContext.getInstance().setLoggedUsername(null);

        return user.get();
    }

}
