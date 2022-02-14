package com.pascualgomz.challengeTopic2.domain;

import org.springframework.stereotype.Component;

@Component
public class HybridPrinter extends Printer {

    private boolean blackAndWhite = true;
    private boolean color = true;

    @Override
    public void print(Document document, boolean color) {
        if (!color) {
            System.out.println("Printing a B&W document " + document.getName() + " on a hybrid printer...");
        } else {
            System.out.println("Printing a color document " + document.getName() + " on a hybrid printer...");
        }
    }


}
