package ua.nenya.main;

import ua.nenya.consoleIO.ConsoleIO;
import ua.nenya.domain.Aircraft;
import ua.nenya.domain.Airline;
import ua.nenya.domain.consts.Const;

import java.io.BufferedReader;
import java.util.List;

public class AirlineRunner {

	public void run(Airline airline, ConsoleIO io, BufferedReader br) {

		Methods methods = new Methods();
		String command;

		do {
			methods.showCommands(io);
			command = io.read(br);

			switch(command) {
				case Const.ONE:
					double totalCapacity = methods.calculateTotalCapacity(airline.getAirCrafts());
					double carryingCapacity = methods.calculateCarryingCapacity(airline.getAirCrafts());
					methods.showResult(io, Const.TOTAL_CAPACITY + totalCapacity);
					methods.showResult(io, Const.CARRYING_CAPACITY + carryingCapacity);
					break;
				case Const.TWO:
					List<Aircraft> sortedAircrafts = methods.sortAircrafts(airline.getAirCrafts());
					methods.showResultAircraftsList(io, sortedAircrafts);
					break;
				case Const.THREE:
					List<Aircraft> aircrafts = methods.findAircraftByFlightRange(br, io, airline.getAirCrafts());
					methods.showResultAircraftsList(io, aircrafts);
					break;
				case Const.S_Q:
				case Const.B_Q:
					break;
				default:
					methods.showResult(io, Const.WRONG_COMMAND);
					break;
			}

			io.writeln(Const.EMPTY);

		} while (!methods.isCommandEqualsRegex(command, Const.QUIT_COMMAND_REGEX));

		io.close(br);

	}

}
