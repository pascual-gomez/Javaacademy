package com.pascualgomz.challengeTopic2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.Printer;

import java.util.List;

@SpringBootApplication
public class ChallengeTopic2Application {

	private static List<Printer> printersList;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeTopic2Application.class, args);
	}

}
