package ua.nenya.service;

import ua.nenya.consoleIO.ConsoleIO;
import ua.nenya.domain.Aircraft;
import ua.nenya.domain.consts.Const;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Service {

    public boolean isCommandEqualsRegex(String command, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(command);
        return m.matches();
    }

    public void showCommands(ConsoleIO io) {
        io.writeln(Const.CHOSE);
        io.writeln(Const.CALCULATE);
        io.writeln(Const.DISPLAY);
        io.writeln(Const.FIND);
        io.writeln(Const.QUIT);
    }

    public double calculateTotalCapacity(List<Aircraft> airline) {
        return airline.stream().map(aircraft -> aircraft.getCapacity()).reduce(0.00, (a, b) -> a + b);
    }

    public void showResult(ConsoleIO io, String message) {
        io.writeln(message);
    }

    public double calculateCarryingCapacity(List<Aircraft> airline) {
        return airline.stream().map(aircraft -> aircraft.getCarryingCapacity()).reduce(0.00, (a, b) -> a + b);
    }

    public List<Aircraft> sortAircraftsByFlightRange(List<Aircraft> airCrafts) {
        return airCrafts.stream().sorted(Comparator.comparingDouble(Aircraft::getFlightRange)).collect(Collectors.toList());
    }

    public List<Aircraft> findAircraftByFuelConsumption(BufferedReader br, ConsoleIO io, List<Aircraft> airCrafts) {

        List<Aircraft> result = null;

        try {
            io.writeln(Const.ENTER_FROM);
            Double from = Double.valueOf(io.read(br));

            io.writeln(Const.ENTER_TO);
            Double to = Double.valueOf(io.read(br));

            if (from.compareTo(to) < 0) {
                result = airCrafts.stream().filter(u -> u.getFuelConsumption() >= from && u.getFuelConsumption() <= to)
                        .collect(Collectors.toList());
            } else {
                io.writeln(Const.WRONG_NUMBERS);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void showResultAircraftsList(ConsoleIO io, List<Aircraft> list) {
        if (list != null && !list.isEmpty()) {
            list.forEach(u -> io.writeln(u.toString()));
        } else {
            io.writeln(Const.EMPTY_LIST);
        }
    }
}
