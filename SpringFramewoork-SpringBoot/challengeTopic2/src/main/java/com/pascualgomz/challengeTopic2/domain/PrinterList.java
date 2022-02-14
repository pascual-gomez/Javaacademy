package com.pascualgomz.challengeTopic2.domain;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrinterList {
    private List<Printer> printersList = new ArrayList<Printer>();

    public void addPrinter(Printer printer) {
        printersList.add(printer);
    }

    public void removePrinter(Printer printer) {
        printersList.remove(printer);
    }

    public List<Printer> getList() {
        return printersList;
    }

    public void print(int i, Document document, boolean color) {
        printersList.get(i).print(document, color);
    }
}
