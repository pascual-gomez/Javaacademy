package com.pascualgomz.challengeTopic2.domain;

import org.springframework.stereotype.Component;

@Component
public class ColorPrinter extends Printer {

    private boolean blackAndWhite = false;
    private boolean color = true;

    @Override
    public void print(Document document, boolean color) {
        if (color) {
            System.out.println("Printing " + document.getName() + " on a color printer...");
        } else {
            System.out.println("This printer does not support B&W printing.");
        }
    }

}
