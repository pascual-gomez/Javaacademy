package com.pascualgomz.challengeTopic2.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class BlackAndWhitePrinter extends Printer {

    private boolean blackAndWhite = true;
    private boolean color = false;

    @Override
    public void print(Document document, boolean color) {
        if (!color) {
            System.out.println("Printing " + document.getName() + " on a black and white printer...");
        } else {
            System.out.println("This printer does not support color printing.");
        }
    }


}
