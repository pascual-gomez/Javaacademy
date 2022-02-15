package com.pascualgomz.challengeTopic2.controller;

import com.pascualgomz.challengeTopic2.domain.Document;
import com.pascualgomz.challengeTopic2.domain.BasicPrinter;
import com.pascualgomz.challengeTopic2.domain.MultifunctionPrinter;
import com.pascualgomz.challengeTopic2.domain.PrinterList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PrinterController {

    @Autowired
    private PrinterList printers;

    public void print(int printer, Document document, boolean color) {
        if (color) {
            if (!printers.getList().get(printer).getType().equals("basic")) {
                printers.getList().get(printer).printColor(document);
            }
        } else {
            if (!printers.getList().get(printer).getType().equals("color"))
            printers.getList().get(printer).printBlackAndWhite(document);
        }
    }

    public void addBasicPrinter(BasicPrinter printer) {
        printers.addBasicPrinter(printer);
    }

    public void addMultifunctionalPrinter(MultifunctionPrinter printer) {
        printers.addMultifunctionPrinter(printer);
    }

    public void removePrinter(int printerIndex) {
        printers.removePrinter(printerIndex);
    }
}
