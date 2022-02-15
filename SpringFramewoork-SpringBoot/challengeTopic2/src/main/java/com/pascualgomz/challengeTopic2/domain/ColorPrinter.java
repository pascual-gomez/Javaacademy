package com.pascualgomz.challengeTopic2.domain;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "color-printer")
public class ColorPrinter implements MultifunctionPrinter {

    @Override
    public void printBlackAndWhite(Document document) {
        System.out.println("This printer do not support b&w printing.");
    }

    public void printColor(Document document) {
        System.out.println("Printing " + document.getName() + " on a color printer...");
    }

    @Override
    public String getType() {
        return "color";
    }

}
