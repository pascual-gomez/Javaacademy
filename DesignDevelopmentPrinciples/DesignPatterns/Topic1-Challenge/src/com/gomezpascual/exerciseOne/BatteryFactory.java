package com.gomezpascual.exerciseOne;

public class BatteryFactory {

    public Battery createBattery(String duration) {
        if (duration == null || duration.isEmpty())
            return null;
        if ("8HOUR".equals(duration)) {
            return new EightHourBattery();
        } else if ("5HOUR".equals(duration)) {
            return new FiveHourBattery();
        }

        return null;
    }

}
