package com.pascualgomz.challengeTopic2.controller;

import com.pascualgomz.challengeTopic2.domain.Document;
import com.pascualgomz.challengeTopic2.domain.Printer;
import com.pascualgomz.challengeTopic2.domain.PrinterList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PrinterController {

    @Autowired
    private PrinterList printers;

    public void print(int printer, Document document, boolean color) {
        printers.print(printer, document, color);
    }

    public void addPrinter(Printer printer) {
        printers.addPrinter(printer);
    }

    public void removePrinter(Printer printer) {
        printers.removePrinter(printer);
    }
}
