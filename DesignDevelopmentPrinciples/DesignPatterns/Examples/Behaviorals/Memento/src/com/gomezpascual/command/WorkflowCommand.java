package com.gomezpascual.command;

public interface WorkflowCommand {

    void execute();

    void undo();
}
