package com.pascualgomez.Thesis.Security;

import com.pascualgomez.Thesis.Entities.User;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public class MyUserSessionDetails implements UserDetails {

    private String username;
    private String password;
    private String idNumber;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public MyUserSessionDetails() {
    }

    public MyUserSessionDetails(String username, String password, String idNumber, String firstName, String lastName, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public static MyUserSessionDetails build(User user) {
        List<GrantedAuthority> authorities =
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getNameRole())).collect(Collectors.toList());
        return new MyUserSessionDetails(user.getUsername(), user.getPassword(), user.getIdNumber(), user.getName(), user.getLastName(), user.getEnabled(), authorities);
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}