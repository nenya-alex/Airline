package ua.nenya.main;

import ua.nenya.consoleIO.ConsoleIO;
import ua.nenya.consoleIOImpl.ConsoleIOImpl;
import ua.nenya.domain.Airline;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
	public static void main(String[] args) {
		ConsoleIO io = new ConsoleIOImpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Initializer initializer = new Initializer();
		Airline airline = initializer.initAirline();

		new AirlineRunner().run(airline, io, br);
	}

}
