package com.pascualgomez.Thesis.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class LabelMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String label;

    @ManyToOne
    @JoinColumn(name = "id_message")
    private Message message;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}
