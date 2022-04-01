package com.pascualgomez.Thesis.Singleton;

import lombok.extern.java.Log;

public class LoggedContext {
    private static final LoggedContext INSTANCE = new LoggedContext();

    // Declaring a variable of type String
    public String loggedUsername = null;

    private LoggedContext() {}

    //Method to get unique instance
    public static LoggedContext getInstance() {
        return INSTANCE;
    }

    public String getLoggedUsername() {
        return loggedUsername;
    }

    public void setLoggedUsername(String loggedUsername) {
        this.loggedUsername = loggedUsername;
    }
}
