package com.pascualgomz.challengeTopic2.domain;

public interface MultifunctionPrinter {

    void printBlackAndWhite(Document document);
    void printColor(Document document);

    String getType();
}

