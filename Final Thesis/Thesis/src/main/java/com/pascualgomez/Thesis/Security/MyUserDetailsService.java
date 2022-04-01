package com.pascualgomez.Thesis.Security;

import com.pascualgomez.Thesis.Entities.User;
import com.pascualgomez.Thesis.Exceptions.UserNotFoundException;
import com.pascualgomez.Thesis.Repositories.UserRepository;
import com.pascualgomez.Thesis.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.getUserByUsername(username);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
        UserDetails toReturn = MyUserSessionDetails.build(user);

        return toReturn;
    }

}
