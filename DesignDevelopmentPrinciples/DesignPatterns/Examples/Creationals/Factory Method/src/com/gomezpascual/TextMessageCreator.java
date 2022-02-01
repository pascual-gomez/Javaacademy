package com.gomezpascual;

import com.gomezpascual.message.Message;
import com.gomezpascual.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new TextMessage();
    }

}
