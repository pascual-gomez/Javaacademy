package com.gomezpascual;

import java.io.IOException;

public class Client {

	public static void main(String[] args) throws IOException {

		Order order = new Order("1010");

		order.addItem("Soda", 2.50);
		order.addItem("Hot dog", 12.00);
		order.addItem("Fries", 6.00);

		OrderPrinter printer = new TextPrinter();
		printer.printOrder(order, "1001.txt");

	}
}
