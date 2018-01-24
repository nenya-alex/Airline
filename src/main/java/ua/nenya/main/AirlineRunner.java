package ua.nenya.main;

import ua.nenya.consoleIO.ConsoleIO;
import ua.nenya.domain.Aircraft;
import ua.nenya.domain.Airline;
import ua.nenya.domain.consts.Const;
import ua.nenya.service.Service;

import java.io.BufferedReader;
import java.util.List;

public class AirlineRunner {

	public void run(Airline airline, ConsoleIO io, BufferedReader br) {

		Service service = new Service();
		String command;

		do {
			service.showCommands(io);
			command = io.read(br);

			switch(command) {
				case Const.ONE:
					double totalCapacity = service.calculateTotalCapacity(airline.getAirCrafts());
					double carryingCapacity = service.calculateCarryingCapacity(airline.getAirCrafts());
					service.showResult(io, Const.TOTAL_CAPACITY + totalCapacity);
					service.showResult(io, Const.CARRYING_CAPACITY + carryingCapacity);
					break;
				case Const.TWO:
					List<Aircraft> sortedAircrafts = service.sortAircraftsByFlightRange(airline.getAirCrafts());
					service.showResultAircraftsList(io, sortedAircrafts);
					break;
				case Const.THREE:
					List<Aircraft> aircrafts = service.findAircraftByFuelConsumption(br, io, airline.getAirCrafts());
					service.showResultAircraftsList(io, aircrafts);
					break;
				case Const.S_Q:
				case Const.B_Q:
					break;
				default:
					service.showResult(io, Const.WRONG_COMMAND);
					break;
			}

			io.writeln(Const.EMPTY);

		} while (!service.isCommandEqualsRegex(command, Const.QUIT_COMMAND_REGEX));

		io.close(br);

	}

}
