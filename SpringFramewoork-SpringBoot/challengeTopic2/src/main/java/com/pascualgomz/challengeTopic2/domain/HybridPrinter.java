package com.pascualgomz.challengeTopic2.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "hybrid-printer")
public class HybridPrinter implements BasicPrinter, MultifunctionPrinter {

    @Override
    public void printBlackAndWhite(Document document) {
        System.out.println("Printing a b&w document " + document.getName() + " on a hybrid printer...");
    }

    @Override
    public void printColor(Document document) {
        System.out.println("Printing a color document " + document.getName() + " on a hybrid printer...");
    }

    @Override
    public String getType() {
        return "hybrid";
    }
}
