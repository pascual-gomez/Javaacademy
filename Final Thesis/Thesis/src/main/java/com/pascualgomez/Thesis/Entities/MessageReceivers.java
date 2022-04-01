package com.pascualgomez.Thesis.Entities;

import com.pascualgomez.Thesis.Singleton.TypeReceiver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(CompositeMessageReceiver.class)
public class MessageReceivers {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User receiver;

    @Id
    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    private Message message;

    private TypeReceiver typeReceiver;
}
