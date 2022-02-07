package com.gomezpascual;


public class Client {

	public static void main(String[] args) {
		Image img = ImageFactory.getImage("A1.bmp");

		img.setLocation(15);
		System.out.println("Location: " + img.getLocation());

		img.render();
	}

}
