package com.pascualgomez.Thesis.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String name;
    private String lastName;
    private String idNumber;
    private String address;
    private String zipCode;
    private String state;
    private String country;
    private String password;
    private Boolean locked;
    private Boolean enabled;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roles;

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "receiver")
    private List<MessageReceivers> receivedMessages;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LabelMessage> labels;
}
