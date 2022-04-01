package com.pascualgomez.Thesis.Entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String subject;
    private String body;
    private String attachment;

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "username")
    private User sender;

    @OneToMany(mappedBy = "message")
    private List<LabelMessage> labelMessage;

    @OneToMany(mappedBy = "message")
    private List<MessageReceivers> receivers;

}
