package com.pascualgomz.challengeTopic2.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "blackandwhite-printer")
public class BlackAndWhitePrinter implements BasicPrinter {


    @Override
    public void printBlackAndWhite(Document document) {
        System.out.println("Printing " + document.getName() + " on a black and white printer...");
    }

    public void printColor(Document document) {
        System.out.println("This printer do not support color printing.");
    }

    @Override
    public String getType() {
        return "basic";
    }
}
