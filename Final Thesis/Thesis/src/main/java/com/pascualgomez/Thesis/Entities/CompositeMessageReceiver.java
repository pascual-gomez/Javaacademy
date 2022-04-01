package com.pascualgomez.Thesis.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositeMessageReceiver implements Serializable {

    private User receiver;
    private Message message;
}
