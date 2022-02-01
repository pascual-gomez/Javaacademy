package com.gomezpascual;

import com.gomezpascual.message.JSONMessage;
import com.gomezpascual.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
