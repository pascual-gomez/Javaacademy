package com.pascualgomz.challengeTopic2.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrinterList {
    private ArrayList printersList = new ArrayList<>();

    public void addBasicPrinter(BasicPrinter printer) {
        printersList.add(printer);
    }

    public void addMultifunctionPrinter(MultifunctionPrinter printer) {
        printersList.add(printer);
    }

    public void removePrinter(int printerIndex) {
        printersList.remove(printerIndex);
    }

    public List<BasicPrinter> getList() {
        return printersList;
    }

}
