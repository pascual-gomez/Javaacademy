package com.pascualgomez.Thesis.Entities;

import lombok.Data;

import javax.persistence.*;



@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nameRole;
    private String descriptionRole;
}