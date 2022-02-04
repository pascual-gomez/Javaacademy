package com.gomezpascual.exerciseOne;

public class ColorFactory {
    public Color createColor(String color) {
        if (color == null || color.isEmpty())
            return null;
        if ("BLUE".equals(color)) {
            return new BlueColor();
        } else if ("GREEN".equals(color)) {
            return new GreenColor();
        }

        return null;
    }
}
