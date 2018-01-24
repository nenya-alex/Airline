package ua.nenya.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import ua.nenya.consoleIO.ConsoleIO;
import ua.nenya.domain.Aircraft;
import ua.nenya.domain.AircraftType;
import ua.nenya.domain.Airline;
import ua.nenya.domain.consts.Const;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class AirlineRunnerTest {

	private Airline airline = new Airline();
	private ConsoleIO mockIo;
	private BufferedReader mockBr;

	@Before
	public void init() {

		List<Aircraft> aircrafts = new ArrayList<>();

		aircrafts.add(new Aircraft(1000, 1000, 1000, 1000, new AircraftType("Airliner")));
		aircrafts.add(new Aircraft(2000, 2000, 2000, 2000, new AircraftType("Airliner")));
		aircrafts.add(new Aircraft(3000, 3000, 3000, 3000, new AircraftType("Cargo Aircraft")));
		aircrafts.add(new Aircraft(4000, 4000, 4000, 4000, new AircraftType("Cargo Aircraft")));
		aircrafts.add(new Aircraft(5000, 5000, 2000, 5000, new AircraftType("Cargo Aircraft")));

		airline.setAirCrafts(aircrafts);

		mockIo = mock(ConsoleIO.class);
		mockBr = mock(BufferedReader.class);
	}

	@Test
	public void runTestQuit() throws IOException {

		when(mockIo.read(mockBr)).thenReturn("q");

		new AirlineRunner().run(airline, mockIo, mockBr);

		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");

	}

	@Test
	public void runTestCalculate() throws IOException {

		when(mockIo.read(mockBr)).thenReturn("1").thenReturn("q");

		new AirlineRunner().run(airline, mockIo, mockBr);

		List<Aircraft> aircrafts = airline.getAirCrafts();

		double totalCapacity = 0;
		double carryingCapacity = 0;
		for (Aircraft aircraft: aircrafts){
			totalCapacity = totalCapacity + aircraft.getCapacity();
			carryingCapacity = carryingCapacity + aircraft.getCarryingCapacity();
		}

		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");

		order.verify(mockIo).writeln("Total Capacity: "+totalCapacity);
		order.verify(mockIo).writeln("Carrying Capacity: "+carryingCapacity);

		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");
	}

	@Test
	public void runTestDisplay() throws IOException {

		when(mockIo.read(mockBr)).thenReturn("2").thenReturn("q");

		new AirlineRunner().run(airline, mockIo, mockBr);

		InOrder order = inOrder(mockIo);

		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");

		order.verify(mockIo).writeln("Aircraft{capacity=1000.0, carryingCapacity=1000.0, flightRange=1000.0, fuelConsumption=1000.0, aircraftType=Airliner}");

		order.verify(mockIo).writeln("Aircraft{capacity=2000.0, carryingCapacity=2000.0, flightRange=2000.0, fuelConsumption=2000.0, aircraftType=Airliner}");
		order.verify(mockIo).writeln("Aircraft{capacity=5000.0, carryingCapacity=5000.0, flightRange=2000.0, fuelConsumption=5000.0, aircraftType=Cargo Aircraft}");
		order.verify(mockIo).writeln("Aircraft{capacity=3000.0, carryingCapacity=3000.0, flightRange=3000.0, fuelConsumption=3000.0, aircraftType=Cargo Aircraft}");
		order.verify(mockIo).writeln("Aircraft{capacity=4000.0, carryingCapacity=4000.0, flightRange=4000.0, fuelConsumption=4000.0, aircraftType=Cargo Aircraft}");

		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");
	}

	@Test
	public void runTestFind() throws IOException {

		when(mockIo.read(mockBr)).thenReturn("3").thenReturn("1000").thenReturn("3000").thenReturn("q");

		new AirlineRunner().run(airline, mockIo, mockBr);

		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");

		order.verify(mockIo).writeln("Aircraft{capacity=1000.0, carryingCapacity=1000.0, flightRange=1000.0, fuelConsumption=1000.0, aircraftType=Airliner}");
		order.verify(mockIo).writeln("Aircraft{capacity=2000.0, carryingCapacity=2000.0, flightRange=2000.0, fuelConsumption=2000.0, aircraftType=Airliner}");
		order.verify(mockIo).writeln("Aircraft{capacity=3000.0, carryingCapacity=3000.0, flightRange=3000.0, fuelConsumption=3000.0, aircraftType=Cargo Aircraft}");

		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");
	}

	@Test
	public void runTestInvalidFind() throws IOException {

		when(mockIo.read(mockBr)).thenReturn("3").thenReturn("3000").thenReturn("1000").thenReturn("q");

		new AirlineRunner().run(airline, mockIo, mockBr);

		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");

		order.verify(mockIo).writeln("Wrong order of entered numbers!");
		order.verify(mockIo).writeln("Result is absent.");

		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");
	}

	@Test
	public void runTestInvalidCommand() throws IOException {

		when(mockIo.read(mockBr)).thenReturn("qwerty").thenReturn("q");

		new AirlineRunner().run(airline, mockIo, mockBr);

		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");

		order.verify(mockIo).writeln("You've chosen wrong command. Try again or quit!");

		order.verify(mockIo).writeln("Chose one command entering the number after command or quit.");
		order.verify(mockIo).writeln("Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1");
		order.verify(mockIo).writeln("Display the list of aircraft of the company sorted by flight range: 2");
		order.verify(mockIo).writeln("Find airplanes corresponding to a given range of fuel consumption parameters: 3");
		order.verify(mockIo).writeln("Quit: q");
	}

}
